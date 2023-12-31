package com.prashant.quizapp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prashant.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findBycategory(String category);
	
	@Query(value="select * from question q where q.category=:category order by RANDOM() limit :numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
