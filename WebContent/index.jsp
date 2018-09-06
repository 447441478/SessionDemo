<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cookie,session技术演示</title>
  </head>
  
  <body>
    <h1>cookie,session技术演示</h1>
    <h2>session技术演示1: 强化一下request、session和application3个容器的作用域</h2>
          往3个容器中存入数据:<br>
    <form action="SaveServlet" method="post">
       Name:<input type="text" name="name" /> <br>
       <input type="submit"/>
    </form>
    <a href="GetServlet">读取3个容器中的数据</a>	
    <!-- 
    黑客盗用别人的账户登录：
    http://localhost:8080/SessionDemo/GetServlet;jsessionid=69DBD069D37C53A84AFA7F48411ECB51
     -->
     
      <h2>重写URL技术---能够让我们的项目Session不依赖于cookie</h2>
    <% String url = response.encodeURL("SaveServlet"); %>
    <form action="<%=url%>" method="post">
       Name:<input type="text" name="name" /> <br>
       <input type="submit"/>
    </form>
    <a href="<%=response.encodeURL("GetServlet")%>">读取3个容器中的数据</a> <br>
    <hr>
    <a href="jsps/ex.jsp">有关session技术使用的两个例子</a>
  </body>
</html>
