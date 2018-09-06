package cn.hncu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet2")
public class SaveServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		//往3个容器中添加
		request.setAttribute("name", name+"---Request");
		request.getSession().setAttribute("name", name+"---Session");
		getServletContext().setAttribute("name", name+"---Application");
		response.getWriter().println("往3个容器中添加成功.");
		//退出浏览器5分钟之内再次访问仍然在线
		///////设置一下JSESSIONID的MaxAge为5分钟就可以了////////
		Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
		cookie.setMaxAge(300); //单位：秒  300 == 60*5
		response.addCookie(cookie);
		//////////////////////////////////////////////////
	}

}
