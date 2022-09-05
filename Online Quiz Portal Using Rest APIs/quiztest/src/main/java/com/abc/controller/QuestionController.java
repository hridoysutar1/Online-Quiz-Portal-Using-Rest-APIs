package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.model.Question;
import com.abc.repository.QuestinonRepository;

@RestController
public class QuestionController {
	
	@Autowired
	QuestinonRepository qrepo;
	
	
	
	@RequestMapping("/")
	public String home() {
		
		return "<h1>Home</h1>";
	}
	
	@PostMapping("/admin/question")
	public ResponseEntity<Question> createQuestion(@RequestBody Question qus) {
		
		
		
		
		try {
			qrepo.save(qus);
		}catch(Exception e) {
			return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(qus ,HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/question/{questionId}")
	public ResponseEntity<Question> findQuestionById(@PathVariable ("questionId") Long questionId ){
		try {
		Question qus=qrepo.getById( questionId);
	
		return new ResponseEntity<>(qus,HttpStatus.FOUND);}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/admin/question")
	public ResponseEntity<List<Question>> allQuestion(@RequestBody Question qus) {
		try {
		List<Question> qlist=qrepo.findAll();
		
		return new  ResponseEntity<>(qlist,HttpStatus.FOUND);}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/question/{questionId}")
	public ResponseEntity<Question> updateQuestionById(@PathVariable ("questionId") Long questionId ,@RequestBody Question newQuestion){
		try {
		Question qus=qrepo.getById( questionId);
		qus.setQuestionAnswer(newQuestion.getQuestionAnswer());
		qus.setQuestionText(newQuestion.getQuestionText());
		
	    qrepo.save(qus);
	
		return new ResponseEntity<>(qus,HttpStatus.OK);}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
