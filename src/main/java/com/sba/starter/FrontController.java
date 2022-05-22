package com.sba.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping()
public class FrontController {
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/ng-app/index.html");
	}
//	
//	@RequestMapping("/ng-app")
//	public String loadIndex() {
//		return "index.html";
//	}

}
