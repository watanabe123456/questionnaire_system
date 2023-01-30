package com.example.questionnaire_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire_system.entity.QuestionnaireInfo;

@Repository
public interface QuestionnaireInfoDAO extends JpaRepository<QuestionnaireInfo, Integer> {

	public List<QuestionnaireInfo> findByQuestionnaireNumber(Integer questionnaireNumber);

	public QuestionnaireInfo findAllByQuestionnaireNumber(Integer questionnaireNumber);

}
