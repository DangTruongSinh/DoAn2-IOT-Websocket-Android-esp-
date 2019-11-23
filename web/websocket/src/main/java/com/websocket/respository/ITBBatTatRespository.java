package com.websocket.respository;

import java.sql.Time;
import java.util.List;

import com.websocket.model.ThietBiBatTat;

public interface ITBBatTatRespository extends IAbstractRespository<ThietBiBatTat>{
	public List<ThietBiBatTat> updateMode(boolean mode, Time thoigianbat, Time thoigiantat);
}
