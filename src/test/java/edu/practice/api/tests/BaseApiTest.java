package edu.practice.api.tests;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseApiTest {

	
	@BeforeSuite
	public void beforeSuite() {
		RestAssured.basePath = "/api";
		RestAssured.baseURI = "https://reqres.in";
	}
	
	public static void print(String data) {
		System.out.println("*******************************************************************************************");
		System.out.println(data);
		System.out.println("===========================================================================================");
	}
}
