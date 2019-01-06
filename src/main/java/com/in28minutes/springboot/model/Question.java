package com.in28minutes.springboot.model;

import java.util.List;

public class Question {
	
	private String id;
	private String header;
	private String description;
	private List<Answer> answers;
	
	public Question(String id, String header, String description, List<Answer> answers) {
		super();
		this.id = id;
		this.header = header;
		this.description = description;
		this.answers = answers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", header=" + header + ", description=" + description + "]";
	}

	
}
