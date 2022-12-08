package edu.practice.api.utils;

import static edu.practice.api.utils.Utility.getSchemaValidationPath;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.module.jsv.JsonSchemaValidator;

public class Utility {

	public static String getSchemaValidationPath() {
		return System.getProperty("user.dir")+"/"+"src/test/resources/edu.practice.api.validation/";
	}
	
	
	public static String convertPojoToJson(Object cls) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cls);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("Json Object is :-");
		System.out.println(json);
		return json;
	}
	
	public static JsonSchemaValidator matchSchema(String jsonFileName) {
		return JsonSchemaValidator.matchesJsonSchema(new File(getSchemaValidationPath()+ "/" + jsonFileName));		
	}
	
	
}
