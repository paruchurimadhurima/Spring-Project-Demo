package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.model.Answer;
import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.QuestionService;


@RestController
public class QuestionController{

	@Autowired
	private QuestionService QuestionService;
	
	@GetMapping("/questions")
	public List<Question> retrieveQuestions() {
		return QuestionService.retrieveAllquestions();
	}
	
	@GetMapping("/questions/{QuestionId}")
	public Question retrieveDetailsForQuestion(@PathVariable String QuestionId) {
		return QuestionService.retrieveQuestion(QuestionId);
	}

	@GetMapping("/questions/{QuestionId}/answers")
	public List<Answer> retrieveAnswersForQuestion(@PathVariable String QuestionId) {
		return QuestionService.retrieveAnswer(QuestionId);
	}
	
	@GetMapping("/questions/{QuestionId}/answers/{AnswerId}")
	public Answer retrieveDetailsForAnswer(@PathVariable String QuestionId,
			@PathVariable String AnswerId) {
		return QuestionService.retrieveAnswer(QuestionId, AnswerId);
	}
	
	@PostMapping("/questions/{QuestionId}/answers")
	public ResponseEntity<Void> registerQuestionForAnswer(
			@PathVariable String QuestionId, @RequestBody Answer newAnswer) {

		Answer Answer = QuestionService.addAnswer(QuestionId, newAnswer);

		if (Answer == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(Answer.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
