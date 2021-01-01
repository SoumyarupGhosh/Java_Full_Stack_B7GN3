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
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	
	
			<jsp:include page="/header" />	 
	
                    	
                       <h2><font color="brown">Password Change</font></h2>
                        <br></br>
		
		
	
		<section class="container-fluid p-4">
		<div c	lass="col-sm-4">
			<form:form action="/changePassword?uci=${uci }" modelAttribute="chgPassword" method="POST" class="form-inline">	
					<label>OldPassword</label><form:input path="oldPassword" type="password" class="form-control mr-2" placeholder="Enter oldpassword" required="required"/>
					<form:errors path="password"/>					
					<br></br>			
					<label>Password</label><form:input path="password" type="password" class="form-control mr-2" placeholder="Enter newPassword"  required="required"/>
					<form:errors path="password"/>					
					<br></br>
					<label>Re-Enter</label><form:input path="confirmPassword" type="password" 	class="form-control mr-2" placeholder=" Enter re-enterpassword"  required="required"/>
					<form:errors path="confirmPassword"/>
					<br></br>
				<button>Submit</button>
			</form:form>
			
			<c:if test="${message !=null}">
					<div style="text-align:centre;margin-left:650px" id="status message"><b>${message}</b></div>
					</c:if>
					<br></br>
					<div style="text-align:center"><a href="setSecurityQuestion?uci=${uci }" >SetYourSecurityQuestion</a></div>
		</div>
	</section>
      <div id=footer>  
		<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
	
	 </div>
    </body>
</html>