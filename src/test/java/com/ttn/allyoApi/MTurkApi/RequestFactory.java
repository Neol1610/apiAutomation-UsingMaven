package com.ttn.allyoApi.MTurkApi;


import com.ttn.allyoApi.Request.IRequest;


public class RequestFactory  {

	
	public static IRequest createRequest(String requestType, String version){
		try{
			IRequest iRequest =  (IRequest)Class.forName(requestType+version).newInstance();
			
		    return iRequest;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
}