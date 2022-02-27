package com.accenture;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
	public 	String add(@RequestParam int t1, @RequestParam int t2, Model model)
	{
		//int i=Integer.parseInt(request.getParameter("t1"));
		//int j=Integer.parseInt(request.getParameter("t2"));
		int k=t1+t2;
		model.addAttribute("result",k);
		return "display";
	}

}

