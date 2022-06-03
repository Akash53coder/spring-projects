package com.xworkz.newspaper.dao;

import java.util.List;

import com.xworkz.newspaper.entity.NewsPaperEntity;

public interface NewsPaperDAO {

	boolean saveNewsPaperEntity(NewsPaperEntity newsPaperEntity);
	NewsPaperEntity getNewsPaperEntity(String newsPaperName);
	List<NewsPaperEntity> getAllNewsPaper();
	boolean deleteNewsPaper(String name);
	boolean updateNewsPaper(NewsPaperEntity newsPaperEntity);
	 
}
