<%@page import="com.dao.EquityDao"%>
<%@page import="com.bean.EquityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		table, th, td {
		  	border: 1px solid black;
		  	border-collapse: collapse;
		}
	</style>
</head>
<body>
	<h1> 
		Welcome, ${user.firstName}
	</h1>
	<table border="1" rule="all">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		
	<%
		EquityDao dao = new EquityDao();
		ArrayList<EquityBean> list = dao.getEquity();
		for(EquityBean bean : list) {		
	%>
		<tr>
			<td>
				<% out.print(bean.getName()); %>
			</td>
			<td>
				<% out.print(bean.getPrice()); %>
			</td>
		</tr>
	<%
		}
	%>
	
	</table>
	
	<a href="LogoutServlet">Logout</a>
</body>
</html>