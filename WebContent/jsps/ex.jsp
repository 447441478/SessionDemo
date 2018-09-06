<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function changImg() {
				imgCode.src ="<%=request.getContextPath()%>/code?"+new Date();
			}
		</script>
	</head>
	<body>
		<h2>利用cookie实现session在浏览器关闭后仍存活。用户在浏览器关闭5分钟内再登录，仍然识别该用户</h2>
	 往3个容器中存入数据:<br>
    <form action="<%=request.getContextPath()%>/SaveServlet2" method="post">
       Name:<input type="text" name="name" /> <br>
       <input type="submit"/>
    </form>
    <a href="<%=request.getContextPath()%>/GetServlet">读取3个容器中的数据</a>
	
	 <h2>验证码在用户登录时的使用</h2>
    用户登录:
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
               姓名:<input type="text" name="name" /> <br>
               密码:<input type="password" name="pwd" /> <br>
               验证码:<input type="text" name="sCode"/> <img id="imgCode" src="<%=request.getContextPath()%>/code" /> <a href="javascript:changImg();">看不清2</a> <br/>
       <input type="submit" value="登录"/>
    </form>
	
	<br><br>
    <a href="<%=request.getContextPath()%>/LogoutServlet">安全退出</a>
	</body>
</html>