package com.ttn.allyoApi.Request.Get;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.relevantcodes.extentreports.LogStatus;
import com.ttn.allyoApi.Request.IRequest;
import com.ttn.allyoApi.Test.TestBase;
import com.ttn.allyoApi.Utilities.Reporter;


public class Get_v2 implements IRequest{
	

	

	public void setFields() {
		
		
	}
	
	public Response sendRequest() {
		
		
		/*RestAssured.baseURI  = "https://remote-insights-api-v3-qa.clavistechnology.com";
		RestAssured.basePath = "/api/v1_9/";
			
		RequestSpecification reqs =  RestAssured.given()
								  	.headers("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6ImRlZmF1bHQifQ.eyJpc3MiOiJodHRwczovL2luc2lnaHRzLWF1dGgtZGV2LmNsYXZpc3RlY2hub2xvZ3kuY29tIiwic3ViIjoiYXBpLXRva2VuLWtjYy11cy04NzQ4NGE0ZDI2Njc0ZmM0YjllZjA2NzM4OTRkMTk5M0BjbGF2aXNpbnNpZ2h0LmNvbSIsImF1ZCI6ImQ0ZTAwMTdmNGIyYzNlOGYiLCJpYXQiOjE1MDk5ODYxNDMsImV4cCI6MTU0MTUyMjE0MywiY3VzdG9tZXJfaWQiOjMsImN1c3RvbWVyX2NvbXBhbnkiOiJLQ0MiLCJjdXN0b21lcl9jb3VudHJ5IjoiVVMiLCJpc19kYSI6ZmFsc2UsImlzX3YzIjp0cnVlLCJpc19hZG1pbl9wb3J0YWwiOmZhbHNlLCJpc19wb2ludF9vZl9zYWxlIjpmYWxzZSwicG9pbnRfb2Zfc2FsZV9wZXJtaXR0ZWRfc3RvcmVzIjpbXSwiYWN0aW5nX2N1c3RvbWVyX2lkIjozLCJhY3RpbmdfY3VzdG9tZXJfY29tcGFueSI6IktDQyIsImFjdGluZ19jdXN0b21lcl9jb3VudHJ5IjoiVVMifQ.QMI0EG6hCq-JYwyEmIqd-02sYuDh-WP0Xv3wHZUyjDQud5qSjy0at79fwAqtzM0uoo_2GSm1q6dmWeCu9Y7LVpf_lhg8VKJKdJhtgvxOXF7ZTt3pP50XxpTfjVib-L-7ao8Vzv7c1_OZNAoiKlyIhUkTmtE-_28ZtRPJ72fLwmwPVE9to0T97hgdke2QqcfAm77DEDB1I2Bmj20Q70Q4EwV68R1gtCNufeuhGfkjzq5N0zhq8R_2H4lJfkgUmEq8SDPLBDkIVVVtiefcW8Z27rG_9EKarvvpZJGWucaC89KS6r1V_LF3F_-6DSNiH9yoA3HbPf5mNRsEd7uogqI6ig")
								  	.headers("Accept","application/vnd.api+json")
								  	.contentType("application/vnd.api+json")
								  	.body(this)
								  	.log()
								  	.everything()
								  	.when();*/

		String url = "https://tatasky-uat-kong.videoready.tv/homescreen/pub/api/v1/page/HOMEPAGE";

		Response res = RestAssured.given().contentType("application/json").when().get(url);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+res.andReturn().asString());
		
		return res;
	}
	
	public RequestSpecification param( RequestSpecification res)
	{
			res.parameters("start-date","2017-07-31");
			res.parameters("end-date","2017-07-31");
			res.parameters("online-store","WALMART");
			res.parameters("brand","Poise");
		
			res.parameters("category","Adult Care");
			res.parameters("dimension1","Incontinence Liners");
			res.parameters("dimension2","Liners_AC");
			res.parameters("dimension3","UNCATEGORIZED");
			
			res.parameters("dimension4","UNCATEGORIZED");
			res.parameters("dimension5","UNCATEGORIZED");
			res.parameters("dimension6","UNCATEGORIZED");
			res.parameters("dimension7","UNCATEGORIZED");
			res.parameters("dimension8","NO");
			
			res.parameters("manufacturer","KCC");
			res.parameters("parent-review","true");
			res.parameters("is-competitor","true");
			res.parameters("review-rating","5");
			
		return res;

	}

	
	
	public void assertFields(Response res){
		//Assert.assertEquals(res.path("data[0].id"), "ID not yet implemented (e4257e4204f6756956c260e361d4a49c)");
		try{
			if(res.path("data[0].type").equals("reviews")){
				TestBase.reporter.test.log(LogStatus.PASS, "Response Time ->");
			}else{
				TestBase.reporter.test.log(LogStatus.FAIL, "Message :: " +res.path("data[0].type"));
			}
		}catch(Exception e){
			TestBase.reporter.test.log(LogStatus.ERROR, e.getMessage());
		}
		
		System.out.println(">>>>>>>>>>>>>"+res.path("data[0].id"));
		
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