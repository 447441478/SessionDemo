package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取3个容器中的值
		String requestName = (String) request.getAttribute("name");
		String sessionName = (String) request.getSession().getAttribute("name");
		String applicationName = (String) getServletContext().getAttribute("name");
		PrintWriter out = response.getWriter();
		out.println("requestName:"+requestName);
		out.println("<br/>sessionName:"+sessionName);
		out.println("<br/>applicationName:"+applicationName);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
