package com.pfyuit.myjavaee.remoting.rest.springmvc;

import com.pfyuit.myjavaee.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring MVC controller, can be used in RESTful web service design. Access
 * http://localhost:8080/myjavaee/springmvc/admin/check to test.
 * @author yupengfei
 */
@Controller
@RequestMapping(value = { "/admin" })
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() throws Exception {
		logger.info("check");
		adminService.check();
		return "success";
	}

}
