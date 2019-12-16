package com.websocket.service;

import com.websocket.respository.impl.TaiKhoanRespository;

public class TaiKhoanService {
	
	public boolean checkAccount(String username, String password)
	{
		TaiKhoanRespository taikhoan = new TaiKhoanRespository();
		return taikhoan.checkAccount(username, password);
	}
}
