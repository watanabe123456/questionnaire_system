package com.example.questionnaire_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire_system.entity.QuestionnaireList;
import com.example.questionnaire_system.service.ifs.QuestionnaireSystemService;
import com.example.questionnaire_system.vo.QuestionnaireReq;
import com.example.questionnaire_system.vo.QuestionnaireRes;
import com.example.questionnaire_system.vo.UserInfoReq;
import com.example.questionnaire_system.vo.UserInfoRes;

@CrossOrigin
@RestController
public class QuestionnaireSystemController {

	@Autowired
	private QuestionnaireSystemService questionnaireSystemService;

	@PostMapping(value = "/api/create_questionnaire_list")
	public QuestionnaireRes createQuestionnaireList(@RequestBody QuestionnaireReq req) {
		return questionnaireSystemService.createQuestionnaireList(req);
	}

	@PostMapping(value = "/api/create_questionnaire_info")
	public QuestionnaireRes createQuestionnaireInfo(@RequestBody QuestionnaireReq req) {
		return questionnaireSystemService.createQuestionnaireInfo(req);
	}

	@PostMapping(value = "/api/update_questionnaire_list")
	public QuestionnaireRes updateQuestionnaireList(@RequestBody QuestionnaireReq req) {
		return questionnaireSystemService.updateQuestionnaireList(req);
	}

	@PostMapping(value = "/api/update_questionnaire_info")
	public QuestionnaireRes updateQuestionnaireInfo(@RequestBody QuestionnaireReq req) {
		return questionnaireSystemService.updateQuestionnaireInfo(req);
	}

	@PostMapping(value = "/api/delete_questionnaire")
	public QuestionnaireRes deleteQuestionnaire(@RequestBody QuestionnaireReq req) {
		return questionnaireSystemService.deleteQuestionnaire(req);
	}

	@PostMapping(value = "/api/select_questionnaire")
	public List<QuestionnaireList> selectQuestionnaire(@RequestBody QuestionnaireReq req) {
		return questionnaireSystemService.selectQuestionnaire(req);
	}

	@PostMapping(value = "/api/show_all_questionnaire")
	public List<QuestionnaireList> showAllQuestionnaire() {
		return questionnaireSystemService.showAllQuestionnaire();
	}

	@PostMapping(value = "/api/creat_user_info_and_answer")
	public UserInfoRes creatUserInfoAndAnswer(@RequestBody UserInfoReq req) {
		return questionnaireSystemService.creatUserInfoAndAnswer(req);
	}

	@PostMapping(value = "/api/show_users_ans")
	public UserInfoRes showUsersAns(@RequestBody UserInfoReq req) {
		return questionnaireSystemService.showUsersAns(req);
	}
}

