package com.example.questionnaire_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.questionnaire_system.vo.QuestionnaireReq;

@Entity
@Table(name = "questionnaire_info")
public class QuestionnaireInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "questionnaire_number")
	private Integer questionnaireNumber;

	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;

	@Column(name = "one_or_multiple")
	private boolean oneOrMultiple;

	@Column(name = "required")
	private boolean required;

	public QuestionnaireInfo() {

	}

	public QuestionnaireInfo(Integer questionnaireNumber, String question, String answer, boolean oneOrMultiple,
			boolean required) {
		this.questionnaireNumber = questionnaireNumber;
		this.question = question;
		this.answer = answer;
		this.oneOrMultiple = oneOrMultiple;
		this.required = required;
	}

	public QuestionnaireInfo(QuestionnaireReq req) {
		this.questionnaireNumber = req.getQuestionnaireNumber();
		this.question = req.getQuestion();
		this.answer = req.getAnswer();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionnaireNumber() {
		return questionnaireNumber;
	}

	public void setQuestionnaireNumber(Integer questionnaireNumber) {
		this.questionnaireNumber = questionnaireNumber;
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

	public boolean isOneOrMultiple() {
		return oneOrMultiple;
	}

	public Boolean getOneOrMultiple() {
		return oneOrMultiple;
	}

	public void setOneOrMultiple(boolean oneOrMultiple) {
		this.oneOrMultiple = oneOrMultiple;
	}

	public boolean getRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

}
