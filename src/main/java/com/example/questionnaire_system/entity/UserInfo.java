package com.example.questionnaire_system.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.questionnaire_system.vo.UserInfoReq;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "questionnaire_number")
	private Integer questionnaireNumber;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_phone")
	private String userPhone;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_age")
	private Integer userAge;

	@Column(name = "users_answer")
	private String usersAnswer;

	@Column(name = "finish_time")
	private LocalDate finishTime = LocalDate.now();

	@Column(name = "gender")
	private String gender;

	public UserInfo() {

	}

	public UserInfo(Integer id, Integer questionnaireNumber, String userName, String userPhone, String userEmail,
			Integer userAge, String usersAnswer, LocalDate finishTime, String gender) {
		this.questionnaireNumber = questionnaireNumber;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.usersAnswer = usersAnswer;
		this.finishTime = finishTime;
		this.gender = gender;
	}

	public UserInfo(UserInfoReq req) {
		this.questionnaireNumber = req.getQuestionnaireNumber();
		this.userName = req.getUserName();
		this.userPhone = req.getUserPhone();
		this.userEmail = req.getUserEmail();
		this.userAge = req.getUserAge();
		this.usersAnswer = req.getUsersAnswer();
		this.gender = req.getGender();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUsersAnswer() {
		return usersAnswer;
	}

	public void setUsersAnswer(String usersAnswer) {
		this.usersAnswer = usersAnswer;
	}

	public LocalDate getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDate finishTime) {
		this.finishTime = finishTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
