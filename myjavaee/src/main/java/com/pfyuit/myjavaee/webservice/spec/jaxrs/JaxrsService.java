package com.pfyuit.myjavaee.webservice.spec.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Access http://localhost:8080/myjavaee/cxf/rest/jaxrs/xxx to test.
 * @author yupengfei
 */
@Path("/jaxrs")
public class JaxrsService {

	@GET
	@Path("/get")
	@Produces("application/json; charset=UTF-8")
	public String testGet() {
		return "success";
	}
}
