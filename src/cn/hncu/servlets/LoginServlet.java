package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//先获取验证码，判断验证码是否正确，正确了才进行后序操作
		String sCode = request.getParameter("sCode");
		String realCode = (String) request.getSession().getAttribute("realCode");
		if( realCode == null || !realCode.equalsIgnoreCase( sCode ) ) {
			out.println("验证输入错误...");
		} else {
			//能到这里说明验证码正确，进行查询用户是否存在
			//这里就模拟了,假设用户名为admin,密码为123，算登录成功
			if ( !"admin".equals( request.getParameter("name") ) ) {
				out.println("用户名错误...");
				return ;
			}
			if ( !"123".equals( request.getParameter("pwd") ) ) {
				out.println("密码错误...");
				return ;
			}
			out.println("恭喜，登录成功！");
		}
		//不管登录是否成功，都要清空验证码
		request.getSession().removeAttribute("realCode");
	}

}
