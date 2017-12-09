package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

/**
 * @author aashish
 *
 */
@Controller
public class RegisterController {
	@Autowired
	public UserService userService;

	/**
	 * @param request
	 * @param response
	 * @return mav -register page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	/**
	 * @param request
	 * @param response
	 * @param user
	 * @return got to login page
	 */
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		userService.register(user);
		HttpSession session = request.getSession(true);

		session.setAttribute("message", "session created");
		return new ModelAndView("redirect:login");
	}

}
