package com.abc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.model.ParticipantDetails;
import com.abc.model.Question;
import com.abc.model.QuestionToParticipant;
import com.abc.model.Quiz;
import com.abc.model.Statistics;
import com.abc.repository.ParticipantDetailsRepo;
import com.abc.repository.QuestinonRepository;
import com.abc.repository.QuizRepository;

@RestController
public class QuizController {
	@Autowired
	QuizRepository qzRepo;
	
	@Autowired
	ParticipantDetailsRepo ptRepo;
	
	@Autowired
	QuestinonRepository qusRepo;
	
	@GetMapping("/admin/quizhome")
	public String quizHome() {
		
		return "<h1>Quiz Home</h1>";
	}
	
	@PostMapping("/admin/quiz")
	public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz qz){
	try {
		qzRepo.save(qz);
		
		return new ResponseEntity<>(qz,HttpStatus.CREATED);}
	    catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	 
	@GetMapping("/admin/quiz")
	public ResponseEntity<List<Quiz>> allQuiz(){
		try {
		List <Quiz> qzList=qzRepo.findAll();
		return new ResponseEntity<>(qzList,HttpStatus.OK);}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/admin/quiz/{id}")
	public ResponseEntity<Quiz> update(@PathVariable ("id") Long id,@RequestBody Quiz qz){
		try {
			Quiz q=qzRepo.getById(id);
			
			q.setQuestionList(qz.getQuestionList());
			q.setQuizName(q.getQuizName());
			
			
		return 	new ResponseEntity<>(q,HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("admin/quiz/{id}")
	public ResponseEntity<Quiz> quizbyid(@PathVariable("id") Long id){
		
		try {
			Quiz qz=qzRepo.getById(id);
			return new ResponseEntity<>(qz,HttpStatus.FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/participant/questionByQuizId/{id}")
	public ResponseEntity<List<QuestionToParticipant>> questionbyquiz(@PathVariable("id") Long id) {
		try {
			Quiz qz=qzRepo.getById(id);
			
			List<Question> ql=qz.getQuestionList();
			
			List<QuestionToParticipant> lqtp=new ArrayList<>();
			for(Question q:ql) {
				QuestionToParticipant qtp=new QuestionToParticipant();
				qtp.setId(q.getQuestionId());
				qtp.setQusText(q.getQuestionText());
				lqtp.add(qtp);
				
			}
			
			return new ResponseEntity<>(lqtp,HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@GetMapping("/admin/stat")
	public ResponseEntity<Statistics> stat() {
		
		try {
		Statistics st=new Statistics();
		st.setQuizNumber(qzRepo.count());
		st.setParticipantNumber(ptRepo.count());
		st.setQuestionNumber(qusRepo.count());
		
		return new  ResponseEntity<>(st,HttpStatus.OK) ;}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}

}
