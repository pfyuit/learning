package com.pfyuit.myjavaee.webservice.rest.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfyuit.myjavaee.dto.business.BlogDto;
import com.pfyuit.myjavaee.dto.business.BlogDtoBuilder;
import com.pfyuit.myjavaee.model.hibernate.BlogModel;
import com.pfyuit.myjavaee.service.database.BlogService;

@Path("/blogservice")
public class BlogJaxRsService {

	@Autowired
	private BlogService blogService;

	@GET
	@Path("/blogs")
	@Produces("application/json; charset=UTF-8")
	public BlogDto findBlogById(@QueryParam("id") Integer id) {
		BlogModel model = blogService.findById(id);
		return BlogDtoBuilder.buildBlogDto(model);
	}
}
