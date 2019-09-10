package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.domain.*;
import org.zerock.service.BoardService;
import org.zerock.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	  @Inject
	  private MainService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpSession session)  throws Exception {
		logger.info("Main ...");
		
 
		model.addAttribute("list", service.Mainlist());
		model.addAttribute("TodayCount",service.TodayCount());
		model.addAttribute("MonthCount",service.MonthCount());
		
		return "home";
	}
	

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String homes(Locale locale, Model model) {
		logger.info("test");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "homes";
	}
	
}
