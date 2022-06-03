package com.xworkz.tvremote.service;

import com.xworkz.tvremote.dao.TVRemoteDAOImpl;
import com.xworkz.tvremote.entity.TvRemoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TVRemoteServiceImpl implements TVRemoteService {

	@Autowired
	TVRemoteDAOImpl tvremote;
//	Just for reference, to check whether bean is created or not
//	public TVRemoteServiceImpl() {
//		super();
//		System.out.println("bean of service created ");
//	}

	@Override
	public boolean validateTVRemoteEntity(TvRemoteEntity entity) {
		if (!entity.getName().isEmpty() && entity.getName() != null && !entity.getName().isBlank()) {
			if (!entity.getColor().isBlank() && !entity.getColor().isEmpty() && entity.getColor() != null) {
				if (entity.getPrice() > 0) {
					if (entity.getNoOfCells() > 0) {
						tvremote.addTvRemoteEntity(entity);
						return true;
					}
				}
			}
		}
		System.out.println("some data are not valid, either they are empty or null");
		return false;

	}

	@Override
	public boolean updateTVRemoteEntity(TvRemoteEntity entity) {
		if (!entity.getName().isEmpty() && entity.getName() != null && !entity.getName().isBlank()) {
			if (!entity.getColor().isBlank() && !entity.getColor().isEmpty() && entity.getColor() != null) {
				if (entity.getPrice() > 0) {
					if (entity.getNoOfCells() > 0) {
						tvremote.updateTvRemoteEntity(entity);
						return true;
					}
				}
			}
		}
		System.out.println("some data are not valid, either they are empty or null");
		return false;
	}

	@Override
	public boolean getColor() {
		String color = tvremote.getColorById(1);
		if (!color.isBlank() && !color.isEmpty() && color != null) {
			System.out.println("color is " + color);
			return true;
		}
		return false;
	}

}
