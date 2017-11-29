<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>

<style type="text/css">
body {
	background-color: #fff2e6;
}

a {
	text-decoration: none;
	color: #737373;
	font-size: 16px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #666666;
	width: 50%;
	overflow: hidden;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	display: block;
	padding: 8px;
	text-align: center;
	text-decoration: none;
}
/* Change the link color to #111 (black) on hover */
li:hover {
	background-color: #4d4d4d;
}

#nav {
	width: 0 auto;
	margin: 0 auto;
	list-style: none;
}

#nav li {
	float: left;
}

#nav a {
	display: block;
	text-align: center;
	width: 150px; /* fixed width */
	text-decoration: none;
}
</style>


</head>
<body>
	<center>

		<ul id="nav">
			<li><a href="books">Books</a></li>
			<li><a href="borrowers/getall">Borrowers</a></li>
			<li><a href="loans">Loans</a></li>
		</ul>

		<br>
		<h1 style="font-size: 50px; color: #333333">Library Management
			System</h1>
		<h2> ${message}</h2>

		<%--<h2>authorname: ${dddd.bookId}</h2>
		<h2>authorId: ${dddd.author}</h2>--%>

		<%-- <c:forEach items="${carti}" var="carte">
			<tr>
				<td>${carte.bookId}</td>
				<td>${carte.author}</td>
			</tr>
		</c:forEach>--%>
		<img
			style="height: 400px; display: flex; align-items: center /* or absolute */"
			src="/WEB_INF/jsp/images/carti.png" />
			
	</center>
</body>
</html>