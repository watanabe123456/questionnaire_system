package com.example.questionnaire_system.vo;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire_system.entity.QuestionnaireInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class QuestionnaireReq {

	private Integer questionnaireNumber;

	private String questionnaireTitle;

	private String questionnaireDescribe;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startTime = LocalDate.now();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endTime = LocalDate.now().plusDays(7);

	private String question;

	private String answer;

	private List<QuestionnaireInfo> qaList;

	private boolean oneOrMultiple;

	private boolean required;

	public QuestionnaireReq() {

	}

	public QuestionnaireReq(Integer questionnaireNumber, String questionnaireTitle, String questionnaireDescribe,
			LocalDate startTime, LocalDate endTime, String question, String answer, List<QuestionnaireInfo> qaList,
			boolean oneOrMultiple, boolean required) {
		this.questionnaireNumber = questionnaireNumber;
		this.questionnaireTitle = questionnaireTitle;
		this.questionnaireDescribe = questionnaireDescribe;
		this.startTime = startTime;
		this.endTime = endTime;
		this.question = question;
		this.answer = answer;
		this.qaList = qaList;
		this.oneOrMultiple = oneOrMultiple;
		this.required = required;
	}

	public Integer getQuestionnaireNumber() {
		return questionnaireNumber;
	}

	public void setQuestionnaireNumber(Integer questionnaireNumber) {
		this.questionnaireNumber = questionnaireNumber;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<QuestionnaireInfo> getQaList() {
		return qaList;
	}

	public void setQaList(List<QuestionnaireInfo> qaList) {
		this.qaList = qaList;
	}

	public Boolean getOneOrMultiple() {
		return oneOrMultiple;
	}

	public void setOneOrMultiple(boolean oneOrMultiple) {
		this.oneOrMultiple = oneOrMultiple;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

}
