package com.example.questionnaire_system.vo;

import com.example.questionnaire_system.entity.QuestionnaireInfo;
import com.example.questionnaire_system.entity.QuestionnaireList;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionnaireRes {

	private QuestionnaireInfo questionnaireInfo;

	private QuestionnaireList questionnaireList;

	private String message;

	public QuestionnaireRes() {

	}

	public QuestionnaireRes(String message) {
		this.message = message;
	}

	public QuestionnaireRes(QuestionnaireList questionnaireList, String message) {
		this.questionnaireList = questionnaireList;
		this.message = message;
	}

	public QuestionnaireRes(QuestionnaireInfo questionnaireInfo, String message) {
		this.questionnaireInfo = questionnaireInfo;
		this.message = message;
	}

	public QuestionnaireRes(QuestionnaireInfo questionnaireInfo, QuestionnaireList questionnaireList, String message) {
		this.questionnaireInfo = questionnaireInfo;
		this.questionnaireList = questionnaireList;
		this.message = message;
	}

	public QuestionnaireInfo getQuestionnaireInfo() {
		return questionnaireInfo;
	}

	public void setQuestionnaireInfo(QuestionnaireInfo questionnaireInfo) {
		this.questionnaireInfo = questionnaireInfo;
	}

	public QuestionnaireList getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(QuestionnaireList questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
