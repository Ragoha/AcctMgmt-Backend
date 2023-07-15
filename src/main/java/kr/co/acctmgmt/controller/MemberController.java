package kr.co.acctmgmt.controller;
import java.util.Locale;



import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;



@Controller

public class MemberController {



	// Ŀ���� ������ - ��ĸ�

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);



	

	@RequestMapping(value = "/member/loginForm")

	public String loginForm(Locale locale, Model model) {

		

		logger.info("�ȳ� - �α��� ��(Hello - Login Form");

		// model.addAttribute("serverTime", formattedDate );

		return "member/loginForm";

	}



	@RequestMapping(value = "/member/accessDenied")

	public String accessDenied(Locale locale, Model model) {

		logger.info("���� ���� - �̵�(Accessed Denied)");

		// model.addAttribute("serverTime", formattedDate );

		return "redirect:/member/accessDeniedView";

	}

	

	@RequestMapping(value = "/member/accessDeniedView")

	public String accessDeniedView(Locale locale, Model model) {

		logger.info("���� ���� - ���(Accessed Denied)");

		// model.addAttribute("serverTime", formattedDate );

		return "member/accessDenied";



	}

	

}