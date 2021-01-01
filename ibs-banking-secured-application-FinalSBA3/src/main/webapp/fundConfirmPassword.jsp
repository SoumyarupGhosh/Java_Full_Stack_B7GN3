<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
   
      <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
    <script>
		   <!-- function openPopUp() 
		    { 
		      	$('#divId').css('display','block'); 
		    	$('#divId').dialog(); 
		    } -->
		    
		    function popup()
		    {
		    	window.open("../customerLogin/fundConfirmPassword/",'window','width=200,height=100');
		    	
		    }
		    
		    
    </script>
        <title>IBS Bank- Change Password</title>
    </head>
   <body>
   <h1>
   <img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /></h2> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	<hr />
	<jsp:include page="/header"/>	
	<br></br>
	<h2><font color="brown"> Confirm Password To Proceed</font></h2>
	<br></br>
			<!--  <a href="javaScript:{openPopUp();}"></a> -->
			<form:form action="/customerLogin/fundConPassword?uci=${uci }" modelAttribute="confirmPassword"  method="POST">
			
					Password: 
					<input name="password" type="password">
					<button>Submit</button>
					 
			</form:form>
			
			<c:if test="${message !=null}">
					<div align ="centre" id="status message"><b>${message}</b></div>
					</c:if>
					 
		</div>
	</section>
      <div id=footer>  
		<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
	 <p>
	 </div>
    </body>
</html>