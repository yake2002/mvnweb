<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标题</title>
</head>

<body>
	${Info} 请输入用户名,密码登陆:
	<form action="/mvnweb/checkLogin.do" meathod="post">
		用户名: <input type="text" name="userName"> <br> 密码: <input
			type="password" name="password"> <br> <input
			type="submit" value="登陆"> <input type="reset" value="重置">
	</form>
</body>

</html>