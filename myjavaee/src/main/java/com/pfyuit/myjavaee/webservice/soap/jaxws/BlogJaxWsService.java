package com.pfyuit.myjavaee.webservice.soap.jaxws;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.pfyuit.myjavaee.dto.business.BlogDto;

@WebService(name = "BlogService", targetNamespace = "com.pfyuit.myjavaee")
public interface BlogJaxWsService {

	public BlogDto findBlogById(@WebParam(name = "id") Integer id);

}
