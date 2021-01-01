<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
   <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		  <link rel="stylesheet" href="/css/registrationForm.css"/>
   
   </style>
        <title>IBS Bank-Set SecurityQnA</title>
    </head>
   <body>
	
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>
	
	
		<jsp:include page="/header" />	
	
	<font color="brown"><h2>Set Your Security Question </h2></font>
	<br></br>

		<section class="container-fluid p-4">
		<div class="col-sm-4">
			<form:form action="/setSecurityQuestion?uci=${uci }" modelAttribute="setSecurityQuestion" method="POST" class="form-Inline">				
						
					<label>Old Password</label><form:input path="oldPassword" type="password" 	class="form-control mr-2" placeholder=" Enter password"/>
					<br></br>
					<label>Question</label> 
					<form:select  path="securityQuestion" >
					 <form:option value="What was your first Pet Name"/>
					 <form:option value='What was your first mobile Number'/>
					 <form:option value='What is your Neighbours Name '/>
					 <form:option value='What is your Wish (in one word)'/>							
					</form:select>	
					<form:errors path="securityQuestion"/>				
					<br></br>
					<label>Answer</label><form:input path="securityAnswer" type="text" 	class="form-control mr-2" placeholder=" Enter LastName"/>
					<form:errors path="securityAnswer"/>
					
					<br></br>
				<button>Submit</button>
			</form:form>
			
			<c:if test="${message !=null}">
					<div style="margin-left:550px" id="status message"><h5>${message}</h5></div>
					</c:if>
		</div>
	</section>
      <div id=footer>  
     
		<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
	 
	 </div>
    </body>
</html>