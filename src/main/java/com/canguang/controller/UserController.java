package com.canguang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/sayHello.action")
	ModelAndView sayHello(@RequestParam String username) {

		// 等价于forward("sayHello.jsp");
		ModelAndView mv = new ModelAndView("sayHello");
		String message = null;
		if (userService.findByName(username)) {
			message = "hello, " + username;
		} else {
			message = "sorry, " + username;
		}

		// 等价于request.setAttribute("message", message);
		mv.addObject("message", message);

		return mv;
	}
}
