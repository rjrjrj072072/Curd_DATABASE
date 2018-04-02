<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="rest/db/register" method="POST">
<br>
Name<input type ="text" name="empName" value="">
</br>
ID<input type ="text" name="id" value="">

<br>
Dept<input type ="text" name="dept" value="">
<br>
Location<input type ="text" name="location" value="">
<br>
WebService Insert
<input type="submit" value="getDetails"/>
</br>
</form>
</body>
</html>