<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
	<head>	
       	<link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		 <style>
		 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/BankLogo.jpg');
		 		 background-repeat: no-repeat;
		 		 background-size:100% 100%;
		 		 background-blend-mode:soft-light;
		 	}
		 </style>
	 	<title>Login</title>
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
	<h2><font color="brown">LOGIN</font></h2>
	<br></br>
		<section class="container-fluid p-4">
		<div class="col-sm-4">
			<form action="/loginPage"  method="POST">
				<c:if test="${param.error != null}">
					Authentication failed! Failure reason could be :
					<br></br>
					1. Either Fields are null.
					2. Invalid Credentials
					3. Access Denied
					4. User doesn't exist.Please Register clicking on register link
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"	
						value="${_csrf.token}" />
				<div class="form-control-group">
					<label class="form-control-label">UserName: </label>
					<input class="form-control" type="text" name="unm" />
				</div> 
				<div class="form-control-group">
					<label class="form-control-label">Password: </label>
					<input class="form-control" type="password" name="pwd" />
				</div>
						
				<div style="text-align:center;margin-left: 20px;"><button>Sign In</button></div>
				
			</form>
		</div>
	</section>
		<div style="text-align:center;margin-left: 20px;"><a href="/changePasswordForget">ForgetPassword?Click Here to Reset</a></div>

	 <div id="footer">
		
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
</body>
</html>
