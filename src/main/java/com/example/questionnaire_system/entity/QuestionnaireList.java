package com.example.questionnaire_system.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.questionnaire_system.vo.QuestionnaireReq;

@Entity
@Table(name = "questionnaire_list")
public class QuestionnaireList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionnaire_number")
	private Integer questionnaireNumber;

	@Column(name = "questionnaire_title")
	private String questionnaireTitle;

	@Column(name = "questionnaire_describe")
	private String questionnaireDescribe;

	@Column(name = "create_time")
	private LocalDateTime createTime = LocalDateTime.now();

	@Column(name = "start_time")
	private LocalDate startTime = LocalDate.now();

	@Column(name = "end_time")
	private LocalDate endTime = LocalDate.now().plusDays(7);

	public QuestionnaireList() {

	}

	public QuestionnaireList(Integer questionnaireNumber, String questionnaireTitle, String questionnaireDescribe,
			LocalDateTime createTime, LocalDate startTime, LocalDate endTime) {
		this.questionnaireTitle = questionnaireTitle;
		this.questionnaireDescribe = questionnaireDescribe;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public QuestionnaireList(QuestionnaireReq req) {
		this.questionnaireTitle = req.getQuestionnaireTitle();
		this.questionnaireDescribe = req.getQuestionnaireDescribe();
		this.startTime = req.getStartTime();
		this.endTime = req.getEndTime();
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

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
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

}
