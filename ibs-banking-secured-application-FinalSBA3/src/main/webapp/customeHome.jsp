<%@page import="java.time.LocalDate"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<html>
	<head>	
		 <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		<style>
		 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/HomeImage1.jpg');
		 		 background-repeat: no-repeat;
		 		 background-size:100% 100%;
		 		 background-blend-mode:screen;
		 	}
		 </style>
	 	<title>IBS Executive</title>
	 	

	</head>
	<body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>			
	<br></br>	
	<h2> Welcome To IBS Banking </h2>
	<div style="text-align:center"><h5>Safe,Secure And Convenient Banking</h5></div>		
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
			
			<ul>
				<jsp:include page="/header"/>
			</ul>
			
			<br></br>
			
			
		
		<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /> </h2>
	
	
	
	
		<div id="footer">
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
	</body>
</html>