package com.xworkz.tvremote.dao;

import com.xworkz.tvremote.entity.TvRemoteEntity;

public interface TVRemoteDAO {

	 void addTvRemoteEntity(TvRemoteEntity tvRemoteEntity);
	 String getColorById(int id);
	 void updateTvRemoteEntity(TvRemoteEntity tvRemoteEntity);
}
