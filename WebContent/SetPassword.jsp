<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<form action="ForgotPassword" method="post">
		<pre>
Enter Email            :  <input type="text" name="email" required
				style="border-radius: 8px; outline: none;"><br></input>
Enter New password     :  <input type="password" name="Npass"
					pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required
					style="border-radius: 8px; outline: none;"><br></input>					
ReType password        :  <input type="password" name="Rpass"
					pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required
					style="border-radius: 8px; outline: none;"><br></input>		
		</pre>
		<input type="submit" style="border-radius: 8px; outline: none; background-color: lightblue;">
		</input>
	</form>
</body>
</html>