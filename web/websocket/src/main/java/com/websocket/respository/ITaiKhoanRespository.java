package com.websocket.respository;

import com.websocket.model.TaiKhoan;

public interface ITaiKhoanRespository extends IAbstractRespository<TaiKhoan> {
	public boolean checkAccount(String username, String password);
}
