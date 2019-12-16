package com.websocket.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.websocket.model.TaiKhoan;

public class TaiKhoanMapper implements IRowMapper<TaiKhoan> {

	@Override
	public TaiKhoan mapRow(ResultSet rs) {
		TaiKhoan taikhoan = new TaiKhoan();
		try {
			taikhoan.setUsername(rs.getString("username"));
			taikhoan.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taikhoan;
	}

}
