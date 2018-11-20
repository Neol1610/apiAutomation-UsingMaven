package com.ttn.allyoApi.Test;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.ttn.allyoApi.MTurkApi.RequestFactory;
import com.ttn.allyoApi.Request.IRequest;

public class MTrurkApiTest extends TestBase {

/*	//@Test
	public void MTurk_test()

	{

		//String url = "http://139.59.81.217:9080/mturkapi/MturkUpload?id=100000000000000025";
		String url = com.ttn.allyoApi.Utilities.GlobalVars.BASE_URL;
		TestBase.reporter.test.log(LogStatus.INFO,"URL is :: "+url);

		IRequest iRequest = RequestFactory.createRequest("com.ncp.Request.MTurkRequest");
		iRequest.setFields();
		
		Response response = iRequest.sendRequest(url);
		iRequest.assertFields(response);

	}
*/
	
	
	@Test
	public void MTurk_test1()

	{

		
		IRequest iRequest = RequestFactory.createRequest("com.ttn.allyoApi.Request.Get.Get_", ver);
		
		iRequest.setFields();
		Response response = iRequest.sendRequest();
		iRequest.setReporter(reporter);	
		iRequest.saveToModel(response);
		iRequest.assertFields(response);

	}
}