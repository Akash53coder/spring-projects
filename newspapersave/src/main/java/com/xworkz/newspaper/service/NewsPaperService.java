package com.xworkz.newspaper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xworkz.newspaper.NewsPaperDTO;

public interface NewsPaperService {

	Map<String,String> map = new HashMap<String,String>();
	boolean validateNewsPaperDTO(NewsPaperDTO newsPaperDTO);
	boolean saveNewsPaperDTO(NewsPaperDTO newsPaperDTO);
	boolean validatesearchNewsPaperName(String newsPaperName);
	NewsPaperDTO getNewsPaperDTO(String newsPaperName);
	List<Object> getAllNewsPaper();
	boolean deleteNewsPaper(String name);
	boolean updateNewsPaper(NewsPaperDTO newsPaperDTO);
}
