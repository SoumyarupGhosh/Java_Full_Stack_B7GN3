<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
    <head>
        <title>IBS Bank-Account Summary</title>
   	 		 <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		 <style> 
     	 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/BankLogoGIf.gif');
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
			<jsp:include page="/header" />	 
	<hr></hr>
                    	
                       <h2><font color="brown">Password Reset</font></h2>
                        <br></br>
		
	
			
		<section class="container-fluid p-4">
		<div c	lass="col-sm-4">
			<form:form action="/changePasswordForgetReset" modelAttribute="chgPasswordReset" method="POST">	
					LoginID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="userId" type="text" class="form-control mr-2" placeholder="Enter userId"/>
					<form:errors path="userId"/>					
					<br></br>
					SecurityQuestion:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form:select  path="securityQuestion" >
					 <form:option value="What was your first Pet Name"/>
					 <form:option value='What was your first mobile Number'/>
					 <form:option value='What is your Neighbours Name '/>
					 <form:option value='What is your Wish (in one word)'/>							
					</form:select>				
					<form:errors path="securityQuestion"/>					
					<br></br>
					SecurityAnswer:&nbsp;<form:input path="securityAnswer" type="text" 	class="form-control mr-2" placeholder=" Enter securityAnswer"/>
					<form:errors path="securityAnswer"/>	
					<br></br>		
					Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="password" type="password" class="form-control mr-2" placeholder="Enter Password"/>
					<form:errors path="password"/>					
					<br></br>
					confirm password:&nbsp;<form:input path="confirmPassword" type="password" 	class="form-control mr-2" placeholder=" Enter confirmPassword"/>
					<form:errors path="confirmPassword"/>
					<br></br>
				<button>Submit</button>
			</form:form>
			
			<c:if test="${message !=null}">
					<div style="margin-left:6500px" id="status message"><h5>${message}</h5></div>
					</c:if>
		</div>
	</section>
      <div id=footer>  
      
		<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
	 
	 </div>
    </body>
</html>