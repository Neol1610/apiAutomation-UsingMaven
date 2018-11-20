package com.ttn.allyoApi.Request;

import com.jayway.restassured.response.Response;
import com.ttn.allyoApi.Utilities.Reporter;

public interface IRequest {

	public void setFields();
	public Response sendRequest();
	public void saveToModel(Response res);
	public void assertFields(Response res);
	public void setReporter(Reporter reporter);
	
}
