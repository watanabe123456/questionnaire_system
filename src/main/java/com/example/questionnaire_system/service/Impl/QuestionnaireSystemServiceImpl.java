package com.example.questionnaire_system.service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_system.constants.QuestionnaireSystemMsgCode;
import com.example.questionnaire_system.entity.QuestionnaireInfo;
import com.example.questionnaire_system.entity.QuestionnaireList;
import com.example.questionnaire_system.entity.UserInfo;
import com.example.questionnaire_system.repository.QuestionnaireInfoDAO;
import com.example.questionnaire_system.repository.QuestionnaireListDAO;
import com.example.questionnaire_system.repository.UserInfoDAO;
import com.example.questionnaire_system.service.ifs.QuestionnaireSystemService;
import com.example.questionnaire_system.vo.QuestionnaireReq;
import com.example.questionnaire_system.vo.QuestionnaireRes;
import com.example.questionnaire_system.vo.UserInfoReq;
import com.example.questionnaire_system.vo.UserInfoRes;

@Service
public class QuestionnaireSystemServiceImpl implements QuestionnaireSystemService {

	@Autowired
	private QuestionnaireListDAO questionnaireListDAO;

	@Autowired
	private QuestionnaireInfoDAO questionnaireInfoDAO;

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public QuestionnaireRes createQuestionnaireList(QuestionnaireReq req) {

		if (!StringUtils.hasText(req.getQuestionnaireTitle())) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.QUESTIONNAIRE_TITLE_REQUIRED.getMessage());
		}

		if (req.getStartTime() != null && req.getStartTime().isAfter(req.getEndTime())) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.START_TIME_ERROR.getMessage());
		}

		if (req.getEndTime() != null && req.getEndTime().isBefore(req.getStartTime())) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.END_TIME_ERROR.getMessage());
		}

		QuestionnaireList questionnaireList = new QuestionnaireList(req);
		if (req.getStartTime() == null) {
			questionnaireList.setStartTime(LocalDate.now());
		}

		if (req.getEndTime() == null) {
			questionnaireList.setEndTime(questionnaireList.getStartTime().plusDays(7));
		}
		questionnaireListDAO.save(questionnaireList);

		return new QuestionnaireRes(questionnaireList, QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	// boolean 輸入 true DB 吃不到
	@Override
	public QuestionnaireRes createQuestionnaireInfo(QuestionnaireReq req) {

		Optional<QuestionnaireList> questionnaireNumberOp = questionnaireListDAO
				.findByQuestionnaireNumber(req.getQuestionnaireNumber());

		if (!questionnaireNumberOp.isPresent()) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.QUESTIONNAIRE_DOSENT_EXIST.getMessage());
		}

		if (!StringUtils.hasText(req.getQuestion())) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.QUESTION_REQUIRED.getMessage());
		}

		if (!StringUtils.hasText(req.getAnswer())) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.ANSWER_REQUIRED.getMessage());
		}

		if (!req.getAnswer().contains(";")) {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.ANSWER_PARAMETER_ERROR.getMessage());
		}

		QuestionnaireInfo questionnaireInfo = new QuestionnaireInfo(req);
		questionnaireInfoDAO.save(questionnaireInfo);
		return new QuestionnaireRes(questionnaireInfo, QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	@Override
	public QuestionnaireRes updateQuestionnaireList(QuestionnaireReq req) {

		QuestionnaireRes res = new QuestionnaireRes();
		Optional<QuestionnaireList> questionnaireOp = questionnaireListDAO
				.findByQuestionnaireNumber(req.getQuestionnaireNumber());

		if (!questionnaireOp.isPresent()) {
			res.setMessage("Please enter correct questionnaire number");
			return res;
		}

		QuestionnaireList questionnaireList = questionnaireOp.get();

		if (StringUtils.hasText(req.getQuestionnaireTitle())) {
			questionnaireList.setQuestionnaireTitle(req.getQuestionnaireTitle());
		}

		if (StringUtils.hasText(req.getQuestionnaireDescribe())) {
			questionnaireList.setQuestionnaireDescribe(req.getQuestionnaireDescribe());
		}

		if (req.getStartTime() != null && !req.getStartTime().isAfter(req.getEndTime())) {
			questionnaireList.setStartTime(req.getStartTime());
		}

		if (req.getEndTime() != null && !req.getEndTime().isBefore(req.getStartTime())) {
			questionnaireList.setEndTime(req.getEndTime());
		}

		questionnaireListDAO.save(questionnaireList);
		return new QuestionnaireRes(QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	@Override
	public QuestionnaireRes updateQuestionnaireInfo(QuestionnaireReq req) {

		QuestionnaireRes res = new QuestionnaireRes();
		Optional<QuestionnaireInfo> questionnaireOp = questionnaireInfoDAO.findById(req.getQuestionnaireNumber());
		if (!questionnaireOp.isPresent()) {
			res.setMessage("Please enter correct questionnaire number");
			return res;
		}

		QuestionnaireInfo questionnaireInfo = questionnaireOp.get();

		if (StringUtils.hasText(req.getQuestion())) {
			questionnaireInfo.setQuestion(req.getQuestion());
		}

		if (StringUtils.hasText(req.getAnswer()) && req.getAnswer().contains(";")) {
			questionnaireInfo.setAnswer(req.getAnswer());
		}

		questionnaireInfoDAO.save(questionnaireInfo);
		return new QuestionnaireRes(QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	@Override
	public QuestionnaireRes deleteQuestionnaire(QuestionnaireReq req) {

		Optional<QuestionnaireList> questionnaireListOp = questionnaireListDAO.findById(req.getQuestionnaireNumber());
		if (questionnaireListOp.isPresent()) {
			questionnaireListDAO.deleteAllByQuestionnaireNumber(req.getQuestionnaireNumber());
		} else {
			return new QuestionnaireRes(QuestionnaireSystemMsgCode.QUESTIONNAIRE_DOSENT_EXIST.getMessage());
		}

		return new QuestionnaireRes(QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	@Override
	public List<QuestionnaireList> selectQuestionnaire(QuestionnaireReq req) {

		// 不篩選
		if (req.getQuestionnaireTitle() == null && req.getStartTime() == null && req.getEndTime() == null) {
			return questionnaireListDAO.findAllByOrderByCreateTimeDesc();
		}
		// 標題搜尋
		else if (StringUtils.hasText(req.getQuestionnaireTitle()) && req.getStartTime() == null
				&& req.getEndTime() == null) {
			return questionnaireListDAO.findAllByQuestionnaireTitleContaining(req.getQuestionnaireTitle());
		}
		// 時間搜尋
		else if (!StringUtils.hasText(req.getQuestionnaireTitle()) && req.getStartTime() != null
				&& req.getEndTime() != null) {
			return questionnaireListDAO.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(req.getStartTime(),
					req.getEndTime());
		}
		// 開始時間搜尋
		else if (!StringUtils.hasText(req.getQuestionnaireTitle()) && req.getStartTime() != null
				&& req.getEndTime() == null) {
			return questionnaireListDAO.findAllByStartTimeGreaterThanEqual(req.getStartTime());
		}
		// 結束時間搜尋
		else if (!StringUtils.hasText(req.getQuestionnaireTitle()) && req.getStartTime() == null
				&& req.getEndTime() != null) {
			return questionnaireListDAO.findAllByEndTimeLessThanEqual(req.getEndTime());
		}
		// 標題+開始時間
		else if (StringUtils.hasText(req.getQuestionnaireTitle()) && req.getStartTime() != null
				&& req.getEndTime() == null) {
			return questionnaireListDAO
					.findAllByQuestionnaireTitleContainingAndStartTimeGreaterThanEqualOrderByStartTimeAsc(
							req.getQuestionnaireTitle(), req.getStartTime());
		}
		// 標題+結束時間
		else if (StringUtils.hasText(req.getQuestionnaireTitle()) && req.getStartTime() == null
				&& req.getEndTime() != null) {
			return questionnaireListDAO.findAllByQuestionnaireTitleContainingAndEndTimeLessThanEqualOrderByEndTimeDesc(
					req.getQuestionnaireTitle(), req.getEndTime());
		}
		return null;
	}

	@Override
	public List<QuestionnaireList> showAllQuestionnaire() {
		return questionnaireListDAO.findAllByOrderByCreateTimeDesc();
	}

	@Override
	public UserInfoRes creatUserInfoAndAnswer(UserInfoReq req) {

		UserInfoRes checkResult = checkParam(req);
		if (checkResult != null) {
			return checkResult;
		}

		UserInfo userInfo = new UserInfo(req);
		userInfo.setFinishTime(LocalDate.now());
		userInfoDAO.save(userInfo);

		return new UserInfoRes(QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	private UserInfoRes checkParam(UserInfoReq req) {

		String phone = "09\\d{8}";
		String email = "[A-za-z0-9]+@[A-za-z0-9]+\\.com";
		if (req.getQuestionnaireNumber() == null || !req.getUserPhone().matches(phone)
				|| !req.getUserEmail().matches(email) || req.getUserAge() <= 0) {
			return new UserInfoRes(QuestionnaireSystemMsgCode.PARAMETER_ERROR.getMessage());
		}
		return null;
	}

	@Override
	public UserInfoRes showUsersAns(UserInfoReq req) {

		if (req.getQuestionnaireNumber() == null) {
			return new UserInfoRes(QuestionnaireSystemMsgCode.QUESTIONNAIRE_NUMBER_REQUIRED.getMessage());
		}

		List<UserInfo> userAns = userInfoDAO.findAllByQuestionnaireNumber(req.getQuestionnaireNumber());

		return new UserInfoRes(userAns, QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UserInfoRes statistics(UserInfoReq req) {
		
		if(req.getQuestionnaireNumber() <= 0 || req.getQuestionnaireNumber() == null) {
			return new UserInfoRes(QuestionnaireSystemMsgCode.QUESTIONNAIRE_NUMBER_REQUIRED.getMessage());
		}

		UserInfoRes res = new UserInfoRes();
		Optional<QuestionnaireList> questionnaire = questionnaireListDAO.findByQuestionnaireNumber(req.getQuestionnaireNumber());
		if (questionnaire == null) {
			return new UserInfoRes(QuestionnaireSystemMsgCode.QUESTIONNAIRE_DOSENT_EXIST.getMessage());
		}

		Integer questionnaireNumber = questionnaire.get().getQuestionnaireNumber();
		List<UserInfo> userInfo = userInfoDAO.findAllByQuestionnaireNumber(questionnaireNumber);
		if (userInfo == null) {
			return new UserInfoRes(QuestionnaireSystemMsgCode.RESULT_ERROR.getMessage());
		}

		List<String> userAns = new ArrayList<>();
		for (UserInfo item : userInfo) {
			userAns.add(item.getUsersAnswer());
		}

		Map<String, Map<String, Integer>> statisticsMap = new HashMap<>();
		for (String item : userAns) {
			for (String item2 : item.split(",")) {
				String question = item2.split("=")[0].trim();
				String answer = item2.split("=")[1].trim();
				if (answer.contains(";")) {
					String[] ansArray = answer.split(";");

					for (String answers : ansArray) {
						mapStatistics(statisticsMap, answers, question);
					}
				} else {
					mapStatistics(statisticsMap, answer, question);
				}
			}
		}

		res.setStatisticsMap(statisticsMap);
		res.setMessage(QuestionnaireSystemMsgCode.SUCCESSFUL.getMessage());
		return res;
	}

	private void mapStatistics(Map<String, Map<String, Integer>> statisticsMap, String answer, String question) {
		Map<String, Integer> ansStatisticsMap = new HashMap<>();

		if (statisticsMap.containsKey(question)) {

			Map<String, Integer> containMap = statisticsMap.get(question);

			if (containMap.containsKey(answer)) {
				int count1 = containMap.get(answer);
				containMap.put(answer, count1 + 1);
			} else {
				containMap.put(answer, 1);
			}

			statisticsMap.put(question, containMap);
		}	else {
			ansStatisticsMap.put(answer, 1);
			statisticsMap.put(question, ansStatisticsMap);
		}

	}

}
