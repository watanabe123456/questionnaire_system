package com.example.questionnaire_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire_system.entity.QuestionnaireInfo;

@Repository
public interface QuestionnaireInfoDAO extends JpaRepository<QuestionnaireInfo, Integer> {

	public QuestionnaireInfo findByQuestionnaireNumber(Integer questionnaireNumber);

}
