package com.example.questionnaire_system.vo;

import java.util.List;
import java.util.Map;

import com.example.questionnaire_system.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoRes {

	private UserInfo userInfo;

	private List<UserInfo> userAns;

	Map<String, Map<String, Integer>> statisticsMap;

	private String message;

	public UserInfoRes() {

	}

	public UserInfoRes(String message) {
		this.message = message;
	}

	public UserInfoRes(List<UserInfo> userAns, String message) {
		this.userAns = userAns;
		this.message = message;
	}

	public UserInfoRes(UserInfo userInfo, String message) {
		this.userInfo = userInfo;
		this.message = message;
	}

	public UserInfoRes(Map<String, Map<String, Integer>> statisticsMap, String message) {
		this.statisticsMap = statisticsMap;
		this.message = message;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserAns() {
		return userAns;
	}

	public void setUserAns(List<UserInfo> userAns) {
		this.userAns = userAns;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Map<String, Integer>> getStatisticsMap() {
		return statisticsMap;
	}

	public void setStatisticsMap(Map<String, Map<String, Integer>> statisticsMap) {
		this.statisticsMap = statisticsMap;
	}

}
