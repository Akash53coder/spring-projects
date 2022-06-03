package com.xworkz.newspaper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.newspaper.NewsPaperDTO;
import com.xworkz.newspaper.dao.NewsPaperDAO;
import com.xworkz.newspaper.entity.NewsPaperEntity;

//Service layer often expose DTO object to the controller
@Service
public class NewsPaperServiceImpl implements NewsPaperService {

	@Autowired
	private NewsPaperDAO newsPaperDAO;
	
	public NewsPaperDAO getNewsPaperDAO() {
		return newsPaperDAO;
	}

	@Override
	public boolean validateNewsPaperDTO(NewsPaperDTO newsPaper) {
		boolean flag = false;
		System.out.println("invoked validateNewsPaperDTO()");
		if (newsPaper.getName() != null && !newsPaper.getName().isEmpty() && !newsPaper.getName().isBlank()) {
			flag = true;
		} else {
			flag = false;
			map.put("name", "Invalid NewsPaper Name");
			System.out.println("Invalid NewsPaper Name");
			return flag;
		}
		if (newsPaper.getLanguage() != null && !newsPaper.getLanguage().isEmpty()
				&& !newsPaper.getLanguage().isBlank()) {
			flag = true;

		} else {
			flag = false;
			map.put("language", "Invalid NewsPaper Language");
			System.out.println("Invalid NewsPaper Language");
			return flag;
		}
		if (newsPaper.getPrice() > 0) {
			flag = true;
		} else {
			flag = false;
			map.put("Price", "Invalid NewsPaper Price");
			System.out.println("Invalid Price");
			return flag;
		}
		if (newsPaper.getNoOfPages() > 0) {
			flag = true;
		} else {
			flag = false;
			map.put("No_of_pages", "Invalid NewsPaper No Of Pages");
			System.out.println("Invalid No Of Pages");
			return flag;
		}
		return flag;

	}

	@Override
	public boolean saveNewsPaperDTO(NewsPaperDTO newsPaperDTO) {

		NewsPaperEntity entity = new NewsPaperEntity();
		// this will copy any DTO object to Entity .copyProperties will take source and
		// target object
		BeanUtils.copyProperties(newsPaperDTO, entity);
		boolean isSaved = this.newsPaperDAO.saveNewsPaperEntity(entity);
		if (isSaved) {
			System.out.println("Data saved");
			return true;
		} else {
			System.out.println("Data not saved");
			return false;
		}

	}

	@Override
	public boolean validatesearchNewsPaperName(String newsPaperName) {
		boolean flag = false;
		if (!newsPaperName.isBlank() && !newsPaperName.isEmpty() && newsPaperName != null) {
			flag = true;
			return flag;
		} else {
			System.out.println("Invalid Keyword Entered");
			flag = false;
			return flag;
		}

	}

	@Override
	public NewsPaperDTO getNewsPaperDTO(String newsPaperName) {
		NewsPaperDTO newsPaperDTO = new NewsPaperDTO();
		NewsPaperEntity entity = this.newsPaperDAO.getNewsPaperEntity(newsPaperName);
		if (entity != null) {
			BeanUtils.copyProperties(entity, newsPaperDTO);
			return newsPaperDTO;
		} else {
			return null;
		}

	}

	@Override
	public List<Object> getAllNewsPaper() {
		System.out.println("Invoked Service getAllNewsPaper");
		List<Object> container = null;
		List<NewsPaperEntity> listEntity = this.newsPaperDAO.getAllNewsPaper();
		if(listEntity!=null) {
			return container = new ArrayList<Object>(listEntity);
		}
		return container;
	}

	@Override
	public boolean deleteNewsPaper(String name) {
		if(!name.isBlank() && !name.isEmpty() && name!=null) {
			boolean isDeleted = this.newsPaperDAO.deleteNewsPaper(name);
			if(isDeleted) {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}

	@Override
	public boolean updateNewsPaper(NewsPaperDTO newsPaperDTO) {
		NewsPaperEntity entity = new NewsPaperEntity();
		// this will copy any DTO object to Entity .copyProperties will take source and
		// target object
		BeanUtils.copyProperties(newsPaperDTO, entity);
		boolean result = this.newsPaperDAO.updateNewsPaper(entity);
		if(result) {
			return true;
		}
		return false;
	}

}
