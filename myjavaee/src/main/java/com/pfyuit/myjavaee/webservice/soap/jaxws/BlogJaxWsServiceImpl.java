package com.pfyuit.myjavaee.webservice.soap.jaxws;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;

import com.pfyuit.myjavaee.dto.business.BlogDto;
import com.pfyuit.myjavaee.dto.business.BlogDtoBuilder;
import com.pfyuit.myjavaee.model.jpa.BlogModel;
import com.pfyuit.myjavaee.service.business.BlogService;

@WebService(serviceName = "BlogService", endpointInterface = "com.pfyuit.myjavaee.webservice.soap.jaxws.BlogJaxWsService", targetNamespace = "com.pfyuit.myjavaee")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class BlogJaxWsServiceImpl implements BlogJaxWsService {

	@Autowired
	private BlogService blogService;

	@Override
	public BlogDto findBlogById(Integer id) {
		BlogModel model = blogService.findById(id);
		return BlogDtoBuilder.buildBlogDto(model);
	}

}
