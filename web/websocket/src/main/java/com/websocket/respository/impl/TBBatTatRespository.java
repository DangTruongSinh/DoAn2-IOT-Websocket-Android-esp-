package com.websocket.respository.impl;

import java.sql.Time;
import java.util.List;

import com.websocket.mapper.ThietBiBatTatMapper;
import com.websocket.model.ThietBiBatTat;
import com.websocket.respository.ITBBatTatRespository;

public class TBBatTatRespository extends AbstractRespository<ThietBiBatTat> implements ITBBatTatRespository{

	@Override
	public List<ThietBiBatTat> findAll() {
		String sql = "select * from thietbibattat";
		return query(sql, new ThietBiBatTatMapper());
	}

	@Override
	public List<ThietBiBatTat> update(ThietBiBatTat object) {
		String sql = "update thietbibattat set trangthai = ? where id = ?";
		update(sql, object.isTrangthai(), object.getId());
		return findAll();
	}

	@Override
	public List<ThietBiBatTat> updateMode(boolean mode, Time thoigianbat, Time thoigiantat) {
		String sql = "update thietbibattat set chedo = ?, thoigianmo= ?, thoigiantat = ?";
		update(sql, mode, thoigianbat, thoigiantat);
		return findAll();
	}
	
}
