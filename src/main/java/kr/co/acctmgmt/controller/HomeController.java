package kr.co.acctmgmt.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



//@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController

public class HomeController {

	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);



	@RequestMapping("/")

	public String home(Locale locale, Model model, Principal principal) {



		logger.info("Welcome home! The client locale is {}.", locale);



		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		

		String username = null;

		

		// Principal ����

		if (principal != null) {

			

			username = principal.getName();

			

			System.out.println("Ÿ������ : " + principal.getClass());

			System.out.println("ID���� : " + principal.getName());

		}

		

		model.addAttribute("username", username);

		model.addAttribute("serverTime", formattedDate );



		return "home";

	}

	

	@RequestMapping("/admin")

	public String admin(Locale locale, Model model) {

		

		return "admin";

	}



	@RequestMapping(value = "/encode-password", method = RequestMethod.GET)

	public String passwordEncode(Locale locale, Model model, HttpServletRequest req) {



		// 1. xml ��Ŀ��� java ������� ��ȯ

		// web.xml ���� ���ŷ� ���� ��� �Ұ�(ServletConfig sc �����)

		// WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getServletContext());

        // PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);



		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		

        String password = req.getParameter("password");

        String encode = passwordEncoder.encode(password);



        model.addAttribute("encode", encode);

        System.out.println(encode);

        

        return "home";

        

	}

	



}