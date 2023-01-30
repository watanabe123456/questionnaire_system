package com.example.questionnaire_system.vo;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire_system.entity.QuestionnaireInfo;
import com.example.questionnaire_system.entity.QuestionnaireList;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionnaireRes {

	private String questionnaireTitle;

	private String questionnaireDescribe;

	private LocalDate startTime;

	private LocalDate endTime;

	private QuestionnaireList questionnaireList;

	private QuestionnaireInfo questionnaireInfo;

	private List<QuestionnaireInfo> questionAndAnswer;

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

	public QuestionnaireRes(List<QuestionnaireInfo> questionAndAnswer, String message) {
		this.questionAndAnswer = questionAndAnswer;
		this.message = message;
	}

	public QuestionnaireRes(String questionnaireTitle, String questionnaireDescribe, LocalDate startTime,
			LocalDate endTime, QuestionnaireList questionnaireList, QuestionnaireInfo questionnaireInfo,
			List<QuestionnaireInfo> questionAndAnswer, String message) {
		this.questionnaireTitle = questionnaireTitle;
		this.questionnaireDescribe = questionnaireDescribe;
		this.startTime = startTime;
		this.endTime = endTime;
		this.questionnaireList = questionnaireList;
		this.questionnaireInfo = questionnaireInfo;
		this.questionAndAnswer = questionAndAnswer;
		this.message = message;
	}

	public String getQuestionnaireTitle() {
		return questionnaireTitle;
	}

	public void setQuestionnaireTitle(String questionnaireTitle) {
		this.questionnaireTitle = questionnaireTitle;
	}

	public String getQuestionnaireDescribe() {
		return questionnaireDescribe;
	}

	public void setQuestionnaireDescribe(String questionnaireDescribe) {
		this.questionnaireDescribe = questionnaireDescribe;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public QuestionnaireList getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(QuestionnaireList questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public QuestionnaireInfo getQuestionnaireInfo() {
		return questionnaireInfo;
	}

	public void setQuestionnaireInfo(QuestionnaireInfo questionnaireInfo) {
		this.questionnaireInfo = questionnaireInfo;
	}

	public List<QuestionnaireInfo> getQuestionAndAnswer() {
		return questionAndAnswer;
	}

	public void setQuestionAndAnswer(List<QuestionnaireInfo> questionAndAnswer) {
		this.questionAndAnswer = questionAndAnswer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
