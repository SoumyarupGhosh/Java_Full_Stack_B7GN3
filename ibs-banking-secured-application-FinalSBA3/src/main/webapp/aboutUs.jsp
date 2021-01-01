<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
	<head>		 
		 <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/> 
	 	<title>IBS-Register</title>
	 	
	 	<style>
		 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/BankLogo.jpg');
		 		 background-repeat: no-repeat;
		 		 background-size:100% 100%;
		 		 background-blend-mode:soft-light;
		 	}
		 </style>
	
	</head>
<body>
		<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>	
	<br></br>	
	<h2> Welcome To IBS Banking </h2>
	<div style="text-align:center"><h5>Safe,Secure And Convenient Banking</h5></div>		
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>

			<hr></hr>
			<ul>
				<jsp:include page="/header"/> 
			</ul>
			<hr></hr>
					
			<br></br>
	
	<h2><font color="brown">About Us</font></h2>
	<br></br>
	<br></br>
	<div style="text-align:center"><h4> Bank offers a wide range of banking products and financial
	 services to corporate and retail customers through a variety of delivery channels and through its group companies. </h4></div>
	
	 <div id="footer">
		 
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
	</body>
	
	</html>