package com.xworkz.newspaper.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.newspaper.NewsPaperDTO;
import com.xworkz.newspaper.service.NewsPaperService;

//controller uses => dispatcherSrvlet delegates the request from UI to controller  
@Controller
@RequestMapping("/")
public class NewsPaperController {

	@Autowired
	private NewsPaperService newsPaperService;

	public NewsPaperController() {
		System.out.println("bean created " + this.getClass().getSimpleName());
	}

	// we need to write handlermethod()
	@RequestMapping("/send.zzz")
	public String handleFirstRequest(@ModelAttribute NewsPaperDTO newsPaperDTO, Model model) {
		// Model is provided by spring which binds the data of UI
		// we can bind all the input fields separately by passing as parameters to
		// handleFirstRequest
		// @ModelAttribute will make use of setter methods to set the values from UI to
		// DTO classes

		boolean isValid = this.newsPaperService.validateNewsPaperDTO(newsPaperDTO);
		if (isValid) {
			boolean isDataSaved = this.newsPaperService.saveNewsPaperDTO(newsPaperDTO);
			if (isDataSaved) {
				model.addAttribute("DataSaved", "Data Saved Successfully");

			} else {
				model.addAttribute("DataNotSaved", "Data Not Saved");
			}

		} else {
			Map<String,String> map = this.newsPaperService.map;
			model.addAttribute("nameNotValid", map.get("name"));
			model.addAttribute("priceNotValid", map.get("Price"));
			model.addAttribute("pageNotValid", map.get("No_of_pages"));
			model.addAttribute("langNotValid", map.get("language"));
		}
		return "index.jsp";
		// Place all the jsp/html files inside web-inf/pages/ which is a standard way
	}

	@RequestMapping("/search.zzz")
	public String searchHandlerMethod(@RequestParam String searchNewsPaper, Model model) {
		System.out.println("Invoked search method");
		if (this.newsPaperService.validatesearchNewsPaperName(searchNewsPaper)) {
			if (this.newsPaperService.getNewsPaperDTO(searchNewsPaper) != null) {
				NewsPaperDTO dto = this.newsPaperService.getNewsPaperDTO(searchNewsPaper);
				model.addAttribute("newsPapername", dto.getName());
				model.addAttribute("newsPaperPrice", dto.getPrice());
				model.addAttribute("newsPaperPages", dto.getNoOfPages());
				model.addAttribute("newsPaperLang", dto.getLanguage());
				return "index.jsp";
			} else {
				model.addAttribute("newsPaperNotFound", "News Paper Not Found");
				return "index.jsp";
			}

		} else {
			model.addAttribute("isSearchValid", "Invalid News Paper Name");
			return "index.jsp";
		}
	}
	
	@RequestMapping("/getAllNewsPaper.zzz")
	public String getAllNewsPaper(Model model) {
		System.out.println("get all newspaper");
		List<Object> allNewsPaper = this.newsPaperService.getAllNewsPaper();
		model.addAttribute("ListOfNewsPaper", allNewsPaper);
		return "index.jsp";
		
	}
	
	@RequestMapping("/deleteNewsPaper.zzz")
	public String deleteNewsPaper(@RequestParam String deleteNewsPaper,Model model) {
		System.out.println("delete news paperController");
		//You can use Validate method in service for deleteNewsPaper
		if(this.newsPaperService.validatesearchNewsPaperName(deleteNewsPaper)) {
			boolean isDeleted = this.newsPaperService.deleteNewsPaper(deleteNewsPaper);
			if(isDeleted) {
				model.addAttribute("NewsPaperDeleted", "News Paper Deleted");
				return "index.jsp";
			}else {
				model.addAttribute("NoNewsPaperFound", "News Paper Not Found");
				return "index.jsp";
			}
		}else {
			model.addAttribute("InvalidNewsPaper", "Invalid News Paper");
			return "index.jsp";
		}
		
		
	}
	
	@RequestMapping("/updateNewsPaper.zzz")
	public String updateNewsPaper(@ModelAttribute NewsPaperDTO newsPaperDTO,Model model) {
		boolean isValid = this.newsPaperService.validateNewsPaperDTO(newsPaperDTO);
		if(isValid) {
			if(this.newsPaperService.updateNewsPaper(newsPaperDTO)) {
				model.addAttribute("newsPaperUpdated", "News Paper Updated");
				return "index.jsp";
			}
		}else {
			model.addAttribute("invalidNewsPaper", "News Paper Invalid Entry");
			return "index.jsp";
		}
		return "index.jsp";
	}

}
