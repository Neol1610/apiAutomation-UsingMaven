package com.ttn.allyoApi.Request.Get;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.relevantcodes.extentreports.LogStatus;
import com.ttn.allyoApi.Request.IRequest;
import com.ttn.allyoApi.Test.TestBase;
import com.ttn.allyoApi.Utilities.Reporter;


public class Get_v1 implements IRequest{
	

	

	public void setFields() {
		
		
	}
	
	public Response sendRequest() {
		
		
		//https://ats-connector-staging.allyo.com/api/v1/applicant/?external_applicant_id=b1b334b9-e847-4e1b-8e06-3a1a1e6232df
		
		
		
		RestAssured.baseURI  = "https://ats-connector-staging.allyo.com";	
		RestAssured.basePath = "/api/v1/";
			
		RequestSpecification reqs =  RestAssured.given()
								  	.headers("Authorization", "Basic YXRzY29ubmVjdG9yOnN0YWdlQDEyMw==")
								  	.headers("retrieval-id","IDT")
								  	.contentType("application/json")
								  	.body(this)
								  	.log()
								  	.everything()
								  	.when();
		
		
		Response res = param(reqs).get("applicant");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+res.andReturn().asString());
		
		
		return res;
	}
	
	public RequestSpecification param( RequestSpecification res)
	{
		res.parameters("external_applicant_id","b1b334b9-e847-4e1b-8e06-3a1a1e6232df");
			
		return res;
	}

	
	
	public void assertFields(Response res){
		
		TestBase.reporter.test.log(LogStatus.INFO, "Response :: " +res.andReturn().asString());
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+res.andReturn().asString());
		
		
		try{
			if(res.path("error").equals("Server Error (500)")){
				TestBase.reporter.test.log(LogStatus.FAIL, "Response Message "+res.path("error"));
			}else{
				TestBase.reporter.test.log(LogStatus.PASS, "Message :: " +res.path("data[0].type"));
			}
		}catch(Exception e){
			TestBase.reporter.test.log(LogStatus.ERROR, e.getMessage());
		}
		
		
		
		/*//Assert.assertEquals(res.path("data[0].id"), "ID not yet implemented (e4257e4204f6756956c260e361d4a49c)");
		
		try{
			if(res.path("data[0].type").equals("reviews")){
				TestBase.reporter.test.log(LogStatus.PASS, "Response Time ->");
			}else{
				TestBase.reporter.test.log(LogStatus.FAIL, "Message :: " +res.path("data[0].type"));
			}
		}catch(Exception e){
			TestBase.reporter.test.log(LogStatus.ERROR, e.getMessage());
		}
		
		System.out.println(">>>>>>>>>>>>>"+res.path("data[0].id"));*/
		
	}
	
	public void saveToModel(Response res){
		/*GlobalVars.getModel = res.getBody().as(GetModel_v1.class);
		GetModel_v1 getModel_v1 = res.getBody().as(GetModel_v1.class);*/
		
	}
	

	public void setReporter(Reporter reporter) {
		/*reporter.startTest("Login", "testing manual sign in");
		test = reporter.getTest();*/
	}
}