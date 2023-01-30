package com.example.questionnaire_system.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire_system.entity.QuestionnaireList;

@Repository
public interface QuestionnaireListDAO extends JpaRepository<QuestionnaireList, Integer> {

	public QuestionnaireList findAllByQuestionnaireTitle(String questionnaireTitle);

	public Optional<QuestionnaireList> findByQuestionnaireNumber(Integer questionnaireNumber);

	@Modifying
	@Transactional
	public void deleteAllByQuestionnaireNumber(Integer questionnaireNumber);

	public List<QuestionnaireList> findAllByQuestionnaireTitleContaining(String questionnaireTitle);

	public List<QuestionnaireList> findAllByStartTimeGreaterThanEqual(LocalDate startTime);

	public List<QuestionnaireList> findAllByEndTimeLessThanEqual(LocalDate endTime);

	public List<QuestionnaireList> findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(LocalDate startTime,
			LocalDate endTime);

	public List<QuestionnaireList> findAllByQuestionnaireTitleContainingAndStartTimeGreaterThanEqualOrderByStartTimeAsc(
			String questionnaireTitle, LocalDate startTime);

	public List<QuestionnaireList> findAllByQuestionnaireTitleContainingAndEndTimeLessThanEqualOrderByEndTimeDesc(
			String questionnaireTitle, LocalDate endTime);

	public List<QuestionnaireList> findAllByOrderByCreateTimeDesc();

	public QuestionnaireList findByQuestionnaireTitle(String questionnaireTitle);

	public QuestionnaireList findQuestionnaireNumberByQuestionnaireTitle(String questionnaireTitle);

}
