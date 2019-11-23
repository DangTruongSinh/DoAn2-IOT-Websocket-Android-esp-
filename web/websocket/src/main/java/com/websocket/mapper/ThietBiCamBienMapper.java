package com.websocket.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.websocket.model.ThietBiCamBien;

public class ThietBiCamBienMapper implements IRowMapper<ThietBiCamBien> {

	@Override
	public ThietBiCamBien mapRow(ResultSet rs) {
		ThietBiCamBien thietbi = new ThietBiCamBien();
		try {
			thietbi.setId(rs.getLong("id"));
			thietbi.setTen(rs.getString("ten"));
			thietbi.setGiatri(rs.getInt("giatri"));
			thietbi.setThoigiandoc(rs.getInt("thoigiandoc"));
			return thietbi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
