package com.shikai.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://localhost")

public interface ServiceBInterface {
	@WebMethod String goodBye (String name);	
}
