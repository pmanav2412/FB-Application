package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostManager {
	@GetMapping(value="/recordAudio")
	public ModelAndView renderIndex() {
		
		 return new ModelAndView("recordAudio");
		
		
	}

}
