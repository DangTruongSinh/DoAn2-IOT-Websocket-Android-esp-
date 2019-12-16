package com.websocket.respository.impl;

import java.util.List;

import com.websocket.mapper.TaiKhoanMapper;
import com.websocket.model.TaiKhoan;
import com.websocket.respository.ITaiKhoanRespository;

public class TaiKhoanRespository extends AbstractRespository<TaiKhoan> implements ITaiKhoanRespository{

	public boolean checkAccount(String username, String password)
	{
		String sql = "select * from taikhoan where username = ? and password = ?";
		if(query(sql, new TaiKhoanMapper(), username, password).size()>0)
			return true;
		return false;
		
	}

	@Override
	public List<TaiKhoan> update(TaiKhoan object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaiKhoan> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
