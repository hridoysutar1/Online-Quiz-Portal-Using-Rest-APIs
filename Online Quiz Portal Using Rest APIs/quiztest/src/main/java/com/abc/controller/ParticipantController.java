package com.abc.controller;

import java.util.ArrayList;
import java.util.List;

//import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.model.CheckAnswer;
import com.abc.model.PAnswer;
import com.abc.model.Question;
import com.abc.model.Quiz;
import com.abc.model.QuizToParticipant;
import com.abc.repository.QuestinonRepository;
import com.abc.repository.QuizRepository;

@RestController
public class ParticipantController {
	@Autowired
	QuizRepository qzRepo;
	
	@Autowired
	QuestinonRepository qusRepo;
	
	
	@PostMapping("/participation/{quizId}")
	public ResponseEntity<List<CheckAnswer>> participation(@PathVariable("quizId") Long quizId, @RequestBody  ArrayList<PAnswer> pa) {
		try {
		
		List<CheckAnswer> cAList=new ArrayList<>();
		
		
		for(PAnswer p:pa) {
			CheckAnswer cA=new CheckAnswer();
			Question q1=qusRepo.getById((long) p.getQlid());
			
			cA.setQusId(p.getQlid());
			cA.setQusText(q1.getQuestionText());
			cA.setCorrectAnswer(q1.getQuestionAnswer());
			cA.setYourAnswer(p.getAns());
			
			String an1=p.getAns();
			String ans2=q1.getQuestionAnswer();
			if(an1.equals(ans2)) {
				cA.setCorrect(true);
			}
			else {
				cA.setCorrect(false);
			}
			cAList.add(cA);
		}
		

		return new ResponseEntity<>(cAList,HttpStatus.OK);}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}
	@GetMapping("/participant/getAllQuiz")
	public ResponseEntity<List<QuizToParticipant>> getAllQuiz() {
		try {
		List<QuizToParticipant> qp=new ArrayList<>();
		List<Quiz> ql=qzRepo.findAll();
		for(Quiz qz:ql) {
			QuizToParticipant pp=new QuizToParticipant();
			
		 pp.setId((int) qz.getQuizId());
		 pp.setName(qz.getQuizName());
		 qp.add(pp);
		 
		}
		return new ResponseEntity<>(qp,HttpStatus.OK);}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	@GetMapping("/standing")
	public void standing(){
		
	}
	
	

}
