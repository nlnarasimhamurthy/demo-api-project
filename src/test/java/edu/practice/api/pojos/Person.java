package edu.practice.api.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.practice.api.utils.Utility;
import net.datafaker.Faker;

public class Person {
	private String name;
	private String job;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	private String id;
	private String createdAt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	
	public String generatePersonData() {
		Faker faker = new Faker();
		this.setName(faker.name().fullName());
		this.setJob(faker.job().title());
		this.setCreatedAt("");
		this.setId("");
		return Utility.convertPojoToJson(this);
	}
}
