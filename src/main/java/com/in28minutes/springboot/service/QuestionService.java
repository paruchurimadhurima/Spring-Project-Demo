package com.in28minutes.springboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.springboot.model.Answer;
import com.in28minutes.springboot.model.Question;

@Component
public class QuestionService {

	private static List<Question> questions = new ArrayList<>();

	static {
		//Initialize Data
		Answer answer1 = new Answer("1", "Answer1............");
		Answer answer2 = new Answer("2", "Answer2............");
		Answer answer3 = new Answer("3", "Answer3............");
		Answer answer4 = new Answer("4", "Answer4............");
				
		Question first = new Question("1", "C doubt",
				"what is C?", new ArrayList<>(Arrays
						.asList(answer1, answer2)));

		Question second = new Question("2", "Py doubt",
				"What is python?", new ArrayList<>(Arrays
						.asList(answer3, answer4)));

		questions.add(first);
		questions.add(second);
	}

	public List<Question> retrieveAllquestions() {
		return questions;
	}

	public Question retrieveQuestion(String QuestionId) {
		for (Question Question : questions) {
			if (Question.getId().equals(QuestionId)) {
				return Question;
			}
		}
		return null;
	}

	public List<Answer> retrieveAnswer(String QuestionId) {
		Question Question = retrieveQuestion(QuestionId);
		
		/*
		if(QuestionId.equalsIgnoreCase("1")){
			throw new RuntimeException("Something went wrong");
		}*/

		if (Question == null) {
			return null;
		}

		return Question.getAnswers();
	}

	public Answer retrieveAnswer(String QuestionId, String AnswerId) {
		Question Question = retrieveQuestion(QuestionId);

		if (Question == null) {
			return null;
		}

		for (Answer Answer : Question.getAnswers()) {
			if (Answer.getId().equals(AnswerId)) {
				return Answer;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Answer addAnswer(String QuestionId, Answer Answer) {
		Question Question = retrieveQuestion(QuestionId);

		if (Question == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		Answer.setId(randomId);

		Question.getAnswers().add(Answer);

		return Answer;
	}
}