package com.pfyuit.myjavaee.remoting.soap.jaxws;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;

/**
 * Standard implementation (using Apache CXF) of JAX-WS specification. Access
 * http://localhost:8080/myjavaee/cxf/soap/jaxws?wsdl to view the WSDL file.
 * @author yupengfei
 */
@WebService(serviceName = "JaxwsService", endpointInterface = "com.pfyuit.myjavaee.remoting.soap.jaxws.JaxwsService", targetNamespace = "com.pfyuit.myjavaee")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class JaxwsServiceImpl implements JaxwsService {

	@Override
	public String testGet() {
		return "success";
	}
}
