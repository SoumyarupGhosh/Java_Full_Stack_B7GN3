<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>IBS Bank-Account Statement</title>
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
   <!--  <body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0"  style="background-color:PaleGoldenRod;">-->
   <body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /></h2> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	          
    <jsp:include page="/header"/>
    
    
    <h4 style="text-align:center">		
			<li class="nav-item ">
      			<a href="/employeeLogin/execAcctStmt?uci=${uci }">CustomerStatement</a>
    		</li>    
    		 <li>
    		 <a href="/employeeLogin/execFundStmt?uci=${uci }">FundDepositStatement</a>
    		 </li> 
    		 <li>
    		 <a href="/employeeLogin/execServiceProviderStmt?uci=${uci }">ServiceProviderPayment</a>
    		 </li>
    		 </h4>  
    
                   
			<div id="footer">
 			<footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
 			</div>
    </body>
</html>
