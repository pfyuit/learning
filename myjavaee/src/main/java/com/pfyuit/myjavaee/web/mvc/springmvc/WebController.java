package com.pfyuit.myjavaee.web.mvc.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView testGet() {
		logger.info("index");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
