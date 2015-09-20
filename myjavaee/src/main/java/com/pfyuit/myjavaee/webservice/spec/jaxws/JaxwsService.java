package com.pfyuit.myjavaee.webservice.spec.jaxws;

import javax.jws.WebService;

@WebService(name = "JaxwsService", targetNamespace = "com.pfyuit.myjavaee")
public interface JaxwsService {

	public String testGet();

}
