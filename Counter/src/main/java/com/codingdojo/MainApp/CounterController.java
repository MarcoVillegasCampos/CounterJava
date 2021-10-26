package com.codingdojo.MainApp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	private void setSessionCount(HttpSession session, int count) {
		session.setAttribute("count", count);}
	
	
	
	private int getSessionCount(HttpSession session) {
		Object sessionValue = session.getAttribute("count");
		if(sessionValue == null) {
			setSessionCount(session, 0);
			sessionValue = session.getAttribute("count");
		}
		return (Integer)sessionValue;
	}

	@RequestMapping("/")
	public String Index(HttpSession session) {
		int count = getSessionCount(session);
		setSessionCount(session, ++count);
		return "welcome.jsp";
	}
		
	@RequestMapping("/add2")
	public String Indexby2(HttpSession session) {
			int count = getSessionCount(session);
			setSessionCount(session, count+=2);
			return "by2.jsp";
	}
	@RequestMapping("/add/{count}")
	public String Add(@PathVariable("count") String count, HttpSession session) {
		int times = 1;
		try {
			times = Integer.parseInt(count);
		}
		catch(NumberFormatException e) {
			System.out.println(String.format("Exception Thrown %s", e.getMessage()));
			return "redirect:/";
		}
		int currCount = getSessionCount(session);
		currCount += times;
		setSessionCount(session, currCount);
		return "welcome.jsp";
	}
	@RequestMapping("/reset")
	public String Reset(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}
	@RequestMapping("/counter")
	public String Counter(HttpSession session, Model model) {
		model.addAttribute("count", getSessionCount(session));
		return "counter.jsp";
		
	}


}
