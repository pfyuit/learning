package com.pfyuit.myjavaee.web.mvc.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;
import com.pfyuit.myjavaee.service.database.rdbms.hibernate.BlogService;

/**
 * Spring MVC controller. It typically used in the Java web design. Access
 * http://localhost:8080/myjavaee/springmvc/web/index to check the index web
 * page.
 * @author yupengfei
 */
@Controller
@RequestMapping(value = { "/web" })
public class WebController {

	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView testGet() {
		BlogModel model = blogService.findById(3);

		logger.info("index");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
