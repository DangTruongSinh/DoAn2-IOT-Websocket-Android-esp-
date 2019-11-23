package com.websocket.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.websocket.model.ThietBiBatTat;

public class ThietBiBatTatMapper implements IRowMapper<ThietBiBatTat> {

	@Override
	public ThietBiBatTat mapRow(ResultSet rs) {
		ThietBiBatTat thietbi = new ThietBiBatTat();
		try {
			thietbi.setId(rs.getLong("id"));
			thietbi.setTen(rs.getString("ten"));
			thietbi.setChedo(rs.getBoolean("chedo"));
			thietbi.setTrangthai(rs.getBoolean("trangthai"));
			thietbi.setThoigianmo(rs.getTime("thoigianmo"));
			thietbi.setThoigiantat(rs.getTime("thoigiantat"));
			return thietbi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
