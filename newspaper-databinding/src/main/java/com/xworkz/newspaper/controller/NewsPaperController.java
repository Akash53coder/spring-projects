package com.xworkz.newspaper.controller;

import org.springframework.stereotype.Component;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.newspaper.NewsPaper;

//controller uses => dispatcherSrvlet delegates the request from UI to controller  
@Component
@RequestMapping("/")
public class NewsPaperController {

	public NewsPaperController() {
		System.out.println("bean created "+this.getClass().getSimpleName());
	}
	
	//we need to write handlermethod()
	@RequestMapping("/send.zzz")
	public String handleFirstRequest(@ModelAttribute NewsPaper newsPaper,Model model) {
		//Model is provided by spring which binds the data of UI
		// we can bind all the input fields separately by passing as parameters to handleFirstRequest
		//@ModelAttribute will make use of setter methods to set the values from UI to DTO classes
		model.addAttribute("Name", newsPaper.getName());
		model.addAttribute("Price", newsPaper.getPrice());
		model.addAttribute("noOfPages", newsPaper.getNoOfPages());
		model.addAttribute("Language", newsPaper.getLanguage());
		//Place all the jsp/html files inside web-inf/pages/ which is a standard way
		return "/WEB-INF/Newspaper.jsp";
	}
	
	

}
