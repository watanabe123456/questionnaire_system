package com.example.questionnaire_system.service.ifs;

import java.util.List;

import com.example.questionnaire_system.entity.QuestionnaireList;
import com.example.questionnaire_system.vo.QuestionnaireReq;
import com.example.questionnaire_system.vo.QuestionnaireRes;
import com.example.questionnaire_system.vo.UserInfoReq;
import com.example.questionnaire_system.vo.UserInfoRes;

public interface QuestionnaireSystemService {

	// 新增問卷列表
	public QuestionnaireRes createQuestionnaireList(QuestionnaireReq req);

	// 新增問卷內容
	public QuestionnaireRes createQuestionnaireInfo(QuestionnaireReq req);

	// 更新問卷列表
	public QuestionnaireRes updateQuestionnaireList(QuestionnaireReq req);

	// 更新問卷內容
	public QuestionnaireRes updateQuestionnaireInfo(QuestionnaireReq req);

	// 刪除問卷(從列表刪除, DB 用外來鍵聯動另外兩張表一起刪)
	public QuestionnaireRes deleteQuestionnaire(QuestionnaireReq req);

	// 搜尋問卷
	public List<QuestionnaireList> selectQuestionnaire(QuestionnaireReq req);

	// 顯示全部問卷(用創建時間倒序)
	public List<QuestionnaireList> showAllQuestionnaire();
	
	//顯示問卷內容
	public QuestionnaireRes showQuestionnaireInfo(QuestionnaireReq req);

	// 新增用戶資料與用戶回答
	public UserInfoRes creatUserInfoAndAnswer(UserInfoReq req);

	// 顯示用戶回答
	public UserInfoRes showUsersAns(UserInfoReq req);

	// 統計
	public UserInfoRes statistics(UserInfoReq req);
}
