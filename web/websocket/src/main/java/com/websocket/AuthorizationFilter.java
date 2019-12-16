package com.websocket;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websocket.model.TaiKhoan;
import com.websocket.service.TaiKhoanService;

public class AuthorizationFilter implements Filter {
	TaiKhoanService taikhoanService = new TaiKhoanService();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		System.out.println("chay:"+username+"-"+password);
		if(username!=null && password!=null)
		{
			boolean result = taikhoanService.checkAccount(username, password);
			if(result)
				chain.doFilter(httpRequest, httpResponse);
			return;
		}		
		TaiKhoan account = (TaiKhoan) httpRequest.getSession().getAttribute("account");	
		String url = httpRequest.getRequestURI();
		if(url.contains("/login"))
		{
			if(account == null)
				chain.doFilter(httpRequest, httpResponse);
			else
				{
					
					if(httpRequest.getParameter("action") != null)
					{
						boolean result = taikhoanService.checkAccount(account.getUsername(),
								account.getPassword());
						if(result)
							chain.doFilter(httpRequest, httpResponse);
					}
					else
						httpResponse.sendRedirect("/trangchu");
				}
			}
			else
			{
				if(account == null) 
					httpResponse.sendRedirect("/login");
				else
				{
					boolean result = taikhoanService.checkAccount(account.getUsername(),
							account.getPassword());
					if(result)
						chain.doFilter(httpRequest, httpResponse);
					else
					httpResponse.sendRedirect("/login");
				}
					
			}
			
		}
		

	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
