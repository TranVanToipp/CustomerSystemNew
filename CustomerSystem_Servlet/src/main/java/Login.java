
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoginDao;
import entyti.Account;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String user = request.getParameter("userName");
			String pass = request.getParameter("password");
			System.out.print(user + pass);
			LoginDao loginDao = new LoginDao();
			Account a = loginDao.CheckLogin(user, pass);
			if (a != null) {
				// Nếu đăng nhập thành công, chuyển hướng tới trang Logins.jsp
				response.sendRedirect("Logins.jsp");
			} else {
				// Nếu đăng nhập không thành công, chuyển hướng tới trang báo lỗi
//				response.sendRedirect("error.jsp");
				//Lưu thông báo lỗi và chuyển hướng trang
				String message = "Sai rồi!!!";
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				 dispatcher.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
