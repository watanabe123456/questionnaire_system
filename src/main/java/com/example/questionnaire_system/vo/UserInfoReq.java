package com.example.questionnaire_system.vo;

public class UserInfoReq {

	private Integer questionnaireNumber;

	private String userName;

	private String userPhone;

	private String userEmail;

	private Integer userAge;

	private String usersAnswer;

	private String gender;

	public UserInfoReq() {

	}

	public UserInfoReq(Integer questionnaireNumber, String userName, String userPhone, String userEmail,
			Integer userAge, String usersAnswer, String gender) {
		this.questionnaireNumber = questionnaireNumber;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.usersAnswer = usersAnswer;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
