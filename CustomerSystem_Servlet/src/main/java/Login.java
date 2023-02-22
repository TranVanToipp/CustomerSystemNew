/**
 * @(#)T001.java 01-00 2021/07/16
 *
 * Copyright(C) 2021 by FUJINET CO., LTD.
 *
 * Last_Update 2021/07/16.
 * Version 1.00.
 */
package fjs.cs.action;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fjs.cs.common.Constants;
import fjs.cs.dao.T001Dao;
import fjs.cs.dto.T001Dto;

/**
 * T001
 * 
 * @version 1.00
 * @since 1.00
 * @author Long-PH
 * 
 */
public class T001 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Init man hinh
	 * 
	 * @param HttpServletRequest  req
	 * @param HttpServletResponse resp
	 * @return RequestDispatcher
	 * @throws ServletException, IOException
	 * @since 1.00
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher myRD = null;
		// Hien thi man hinh Login
		myRD = req.getRequestDispatcher(Constants.T001_LOGIN);
		myRD.forward(req, resp);
	}

	/**
	 * Event man hinh
	 * 
	 * @param HttpServletRequest  req
	 * @param HttpServletResponse resp
	 * @return RequestDispatcher
	 * @throws ServletException, IOException
	 * @since 1.00
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			String user = req.getParameter("userName");
			String pass = req.getParameter("password");
			System.out.print(user + pass);
			T001Dao loginDao = new T001Dao();
			T001Dto result = loginDao.CheckLogin(user, pass);
			
			/**
			 * Nếu đăng nhập thành công, chuyển hướng tới trang T002_Search
			 * Ngoài ra: Lưu thông báo lỗi và chuyển hướng trang T001_Login
			 * thông báo lỗi.
			 */
			if (result != null) {
				resp.sendRedirect("/CustomerSystem/T002");
			} else {
				String message = "ユーザーIDまたはパスワードが不正です。";
				req.setAttribute("message", message);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/T001.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
