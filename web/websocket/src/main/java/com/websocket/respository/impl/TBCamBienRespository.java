package com.websocket.respository.impl;

import java.util.List;

import com.websocket.mapper.ThietBiCamBienMapper;
import com.websocket.model.ThietBiCamBien;

public class TBCamBienRespository extends AbstractRespository<ThietBiCamBien> {

	@Override
	public List<ThietBiCamBien> findAll() {
		String sql = "select * from thietbicambien";
		return query(sql, new ThietBiCamBienMapper());
	}

	@Override
	public List<ThietBiCamBien> update(ThietBiCamBien object) {
		String sql = "update thietbicambien set giatri = ?, thoigiandoc = ? where id = ?";
		update(sql, object.getGiatri(), object.getThoigiandoc(), object.getId());
		return findAll();
	}

}
