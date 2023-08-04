package com.prashant.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.GetOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prashant.quizapp.dao.QuestionDao;
import com.prashant.quizapp.dao.QuizDao;
import com.prashant.quizapp.model.Question;
import com.prashant.quizapp.model.QuestionWrapper;
import com.prashant.quizapp.model.Quiz;
import com.prashant.quizapp.model.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
		for(Question q :questionFromDB) {
			QuestionWrapper qWrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qWrapper);
		}
		
		return new ResponseEntity<>(questionForUser, HttpStatus.OK); 
	}

	public ResponseEntity<Integer> caluculate(int id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i=0;
	
		for(Response res: responses) {
			if(res.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

	
	
		
	
}
