<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>


<style type="text/css">
body {
	background-color: #fff2e6;
}

h1 {
	color: #595959;
}

th, td {
	white-space: nowrap;
	border: 2px solid #666666;
	background-color: white;
	padding: 12px;
	border-spacing: 0px;
	margin: 0px;
}

th {
	background-color: #999999;
}

table {
	border-collapse: collapse;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	width: 30%;
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
	width: 12%;
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
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/bookss">Add</a></li>
			<li><a href="/books/getallaa">List</a></li>
		</ul>
		
		<h1>Books List</h1>
	</center>
	<table>
		<tr>
			<th>Book Id</th>
			<th>Author</th>
			<th>Title</th>
			<th>Description</th>
			<th>Borrowed</th>

			<th>Options</th>
			<th></th>

		</tr>

		<c:forEach var="books" items="${books}">
			<tr>



				<td>${books.bookId}</td>
				<td>${books.author}</td>

				<td>${books.title}</td>

				<td>${books.subject}</td>
				<td>${books.borrowed}</td>

	
				<td>
					<form style="display: inline-block;"
						action="/delete/${books.bookId}"
						method="POST">
						<input type="submit" name="submit" value="Delete" /> <input
							type="hidden" name="action" value="confirmDelete" /> <input
							type="hidden" name="book_Id"
							value="<c:out value="${books.bookId}"/>" />
					</form>

				<!-- 	<form style="display: inline-block;"
						action="/book/save/${books.bookId}" 
						method="POST">
						<input type="submit" name="submit" value="Update" /><input
							type="hidden" name="book_Id"
							value="<c:out value="${books.bookId}"/>" />
					</form> -->

				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>