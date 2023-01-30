package com.example.questionnaire_system.constants;

public enum QuestionnaireSystemMsgCode {

	SUCCESSFUL("200", "Successful"), 
	QUESTIONNAIRE_TITLE_EXISTED("403", "Questionnaire existed!!"),
	QUESTIONNAIRE_TITLE_REQUIRED("400", "Questionnaire title cannot be null or empty!!"),
	QUESTIONNAIRE_NUMBER_REQUIRED("400", "Questionnaire number cannot be null or empty!!"),
	QUESTION_REQUIRED("400", "Question cannot be null or empty!!"),
	ANSWER_REQUIRED("400", "Option cannot be null or empty!!"), 
	ANSWER_PARAMETER_ERROR("403", "Answer parameter error"),
	START_TIME_ERROR("403", "Start time error"), 
	END_TIME_ERROR("403", "End time error"),
	PARAMETER_ERROR("403", "parameter error"), 
	QUESTIONNAIRE_DOSENT_EXIST("403", "Questionnaire doesn't exist!!"),
	RESULT_ERROR("403", "Result error"),;

	private String code;

	private String message;

	private QuestionnaireSystemMsgCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
