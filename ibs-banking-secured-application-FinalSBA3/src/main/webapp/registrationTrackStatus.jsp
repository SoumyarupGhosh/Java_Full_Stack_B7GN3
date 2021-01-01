<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	 	<title>IBS- Track Status</title>
	
</script>
	</head>
<body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>	
	<br></br>	
	<h2> Welcome To IBS Banking </h2>
	<div style="text-align:center"><h5>Safe,Secure And Convenient Banking</h5></div>		
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>
	
	<hr>
	<jsp:include page="/header"/>
	<hr>
	<br></br>
	

					<form action="/registrationForm/trackStatus" method="POST"  class="form-inline">	
					<div>			
						<form:errors path="*" />
					</div>
					<h2><b><font color="brown">Track Status</font></b></h2>
					<br></br>
					<br></br>
					RegistrationId : <input name="registrationid" type="number" class="form-control mr-2" placeholder="Enter registrationid" required/>					
					<br></br>
					<input value="Submit" type="submit" />
					</form>
				<div style="text-align:center">						
					<c:if test="${messageStatus !=null}">
					<div id="status message"><b>${messageStatus}</b></div>
					</c:if>
				</div>
	 <div id="footer">
		 <p>
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
</body>
</html>