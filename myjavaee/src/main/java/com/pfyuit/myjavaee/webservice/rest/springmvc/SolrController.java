package com.pfyuit.myjavaee.webservice.rest.springmvc;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.service.search.SolrService;

@Controller
@RequestMapping(value = { "/solr" })
public class SolrController {

	@Autowired
	private SolrService solrService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Integer> searchBlog() throws SolrServerException {
		return solrService.searchBlog("mysql");
	}
}
