package com.pfyuit.myjavaee.spec.webservice.jaxws;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;

/**
 * Access http://localhost:8080/myjavaee/cxf/soap/jaxws?wsdl to view the wsdl file.
 * @author yupengfei
 */
@WebService(serviceName = "JaxwsService", endpointInterface = "com.pfyuit.myjavaee.spec.webservice.jaxws.JaxwsService", targetNamespace = "com.pfyuit.myjavaee")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class JaxwsServiceImpl implements JaxwsService {

	@Override
	public String testGet() {
		return "success";
	}
}
