package com.pfyuit.myjavaee.remoting.soap.jaxws;

import javax.jws.WebService;

/**
 * Standard interface (using Apache CXF) of JAX-WS specification.
 * @author yupengfei
 */
@WebService(name = "JaxwsService", targetNamespace = "com.pfyuit.myjavaee")
public interface JaxwsService {

	public String testGet();

}
