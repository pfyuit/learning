package com.pfyuit.myjavaee.remoting.rest.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Standard implementation (using Apache CXF) of JAX-RS specification. Access
 * http://localhost:8080/myjavaee/cxf/rest/jaxrs/get to test.
 * @author yupengfei
 */
@Path("/jaxrs")
public class JaxrsService {
	
	private static Logger logger = LoggerFactory.getLogger(JaxrsService.class);

	@GET
	@Path("/get")
	@Produces("application/json; charset=UTF-8")
	public String testGet() {
		logger.info("Execute /get");
		return "success";
	}
}
