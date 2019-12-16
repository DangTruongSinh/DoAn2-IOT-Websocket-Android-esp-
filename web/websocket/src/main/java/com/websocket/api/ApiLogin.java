package com.websocket.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.model.TaiKhoan;
import com.websocket.service.TaiKhoanService;
import com.websocket.utils.HttpUtil;

@WebServlet(urlPatterns = {"/account-api"})
public class ApiLogin extends HttpServlet{
	private TaiKhoanService taiKhoanService = new TaiKhoanService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		TaiKhoan taikhoan =  HttpUtil.of(req.getReader()).toModel(TaiKhoan.class);
		boolean check =  taiKhoanService.checkAccount(taikhoan.getUsername(), taikhoan.getPassword());
		if(check)
			mapper.writeValue(resp.getOutputStream(), true);
		else
			mapper.writeValue(resp.getOutputStream(),false);
	}
}
