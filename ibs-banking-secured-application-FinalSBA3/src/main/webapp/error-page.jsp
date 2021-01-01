<%@ page import="java.time.LocalDate"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
 
<html>
	<head>
		<link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		<title>IBS-Home</title>	
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
		 
		 <section class="container-fluid p-4">
			<div class="card card-danger">
				<div class="card-header">
				<br></br>
					<h3>An Error Occurred While Processing Your Request</h3>
					<br></br>
				</div>
				<div class="card-body">
					<h3>${errMsg }</h5>
					<br></br>
					<div style="text-align:center"><button onclick="javascript:window.history.back()">Back Button</button></div>
				</div>
			</div>
		</section>
		<div id=footer>  
      
		<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
	 	</div>
	</body>
</html>