<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<body>

<% String  operation = request.getParameter("operation");

if(operation.equals("insert"))

{ session.setAttribute("operation", "insert");

%>

 

<form action="CurdO">

  name:<br/>

  <input type="text" name="name" value="" onclick="this.value=''"/>

 

 <br/>ID :<br/>

  <input type="text" name="id" value="" onclick="this.value=''"/>

 

  <br/>dept:<br/>

  <input type="text" name="dept" value=""/>

               <br/>location:<br/>

  <input type="text" name="location" value=""/><br/>

  <input type="submit" value="Submit"/>

</form>

<%

}

if(operation.equals("select"))

{

session.setAttribute("operation", "select");

response.sendRedirect("CurdO");

}

if(operation.equals("delete"))

{

session.setAttribute("operation", "delete");

%>

<form action="CurdO">

<table><tr> <td>id:</td><td><input type="text" name="id" >"></td></tr>

 

 </table>

<input type="submit" value="Submit"/></form>

<%

}

%>

<%

if(operation.equals("update"))

{

         session.setAttribute("operation", "update");

%>

<form action="CurdO">

<table><tr> <td>Name:</td><td><input type="text" name="name" >"></td></tr>

 

            <tr> <td>id</td><td><input type="text" name="id" ></td></tr>

            <tr> <td>deptartment:</td><td><input type="text" name="dept" ></td></tr>

            <tr> <td>location:</td><td><input type="text" name="location" ></td></tr>        

            </table><input type="submit" value="Submit"/>

</form>

<%

}%>

</body>

</html>