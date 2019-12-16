package com.websocket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.websocket.model.TaiKhoan;
import com.websocket.service.TaiKhoanService;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet{
	private TaiKhoanService taikhoanService = new TaiKhoanService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("logout"))
			req.getSession().removeAttribute("account");
		resp.sendRedirect("/views/login.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("taikhoan");
		String password = req.getParameter("matkhau");
		if(username!=null && password!=null)
		{
			boolean result = taikhoanService.checkAccount(username, password);
			if(result)
			{
				TaiKhoan account = new TaiKhoan(username,password);
				HttpSession session = req.getSession();
				session.setAttribute("account", account);
				resp.sendRedirect("/trangchu");
			}
			else
			{
				req.setAttribute("message", "Account not correct");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}
		}
		
	}

}
