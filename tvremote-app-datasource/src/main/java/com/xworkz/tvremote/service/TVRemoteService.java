package com.xworkz.tvremote.service;

import com.xworkz.tvremote.entity.TvRemoteEntity;

//Service layer mainly used for validations and business logics
public interface TVRemoteService {
	boolean validateTVRemoteEntity(TvRemoteEntity entity);
	boolean updateTVRemoteEntity(TvRemoteEntity entity);
	boolean getColor();
}
