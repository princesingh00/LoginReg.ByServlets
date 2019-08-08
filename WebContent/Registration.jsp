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
	<form action="Registration" method="get">
		<pre>
		Enter First Name : <input type="text" name="firstname" required
				style="border-radius: 8px; outline: none;"></input>
		
		Enter Last Name  : <input type="text" name="lastname" required
				style="border-radius: 8px; outline: none;"></input>
		
		Enter User Name  : <input type="text" name="uname" required
				style="border-radius: 8px; outline: none;"></input>
		
		Enter Email      : <input type="text" name="email" required
				style="border-radius: 8px; outline: none;"></input>
		
		Enter Mobile     : <input type="text" name="phone"
				pattern="[7-9][0-9]{9}"
				title="mobile number must be 10 digit it's should start with 7,8 or 9"
				required style="border-radius: 8px; outline: none;"></input>
		
		Enter Password   : <input type="password" name="pass"
				pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
				title="must be 8 alphabet with special symbol" required
				style="border-radius: 8px; outline: none;"></input>
					
		<input type="submit"
				style="border-radius: 8px; outline: none; background-color: lightblue;"></input>
						
		</pre>
	</form>
</body>
</html>