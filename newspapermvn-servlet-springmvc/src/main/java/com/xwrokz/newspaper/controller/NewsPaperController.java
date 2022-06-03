package com.xwrokz.newspaper.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

//controller uses => dispatcherSrvlet delegates the request from UI to controller  
@Component
@RequestMapping("/")
public class NewsPaperController {

	public NewsPaperController() {
		System.out.println("bean created "+this.getClass().getSimpleName());
	}
	
	//we need to write handlermethod()
	@RequestMapping("/news.zzz")
	public void handleFirstRequest() {
		System.out.println("First handler method called");
	}
	
	@RequestMapping("/news-24.zzz")
	public void handleSecondRequest() {
		System.out.println("Second handler method called");
	}
	
	@RequestMapping("/news-9.zzz")
	public void handleThirdRequest() {
		System.out.println("Third handler method called");
	}
}
