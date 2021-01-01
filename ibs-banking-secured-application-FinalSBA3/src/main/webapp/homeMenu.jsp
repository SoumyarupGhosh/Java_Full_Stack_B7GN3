<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %><html>
<head>
<style>
 <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
  
</style>
</head> 
   

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 
  
    <c:choose>
    	<c:when test="${uci != null }">
    	<!--  <b><span>Welcome ${uci }</span></b>-->
    	<c:if test="${PassChange=='notRequires' }">		   
		   					 <c:if test="${role=='Employee' }">						    	
						    	
				      				
				      				 <jsp:include page="employeeMenuTBD.jsp"/>
				    			    
					    	</c:if> 
					   		 <c:if test="${role=='Customer' }">
						    			
				                        <jsp:include page="customerMenu.jsp"/>
				                        			                       
				    			   
		    				</c:if>
		    				<c:if test="${role=='ServiceProvider' }">
		    					    	
						    		
						    			 <jsp:include page="serviceProviderMenu.jsp"/>
				    			  
					    	</c:if>
		    
		    </c:if> 
		     <c:if test="${PassChange=='requires' }">
		     				<li class="nav-item ">
			      				<a class="nav-link" href="/changePassword?uci=${uci }">ChangePasswordForFirstLogin</a>
			    			</li>
			    										
			    			<li class="nav-item ">		     	     		
		     				    <a class="nav-link" href="logout"> Log Out</a>
		    				</li>
		    				<hr></hr>
		      </c:if>
		      		
		      
		    		
    	</c:when>
    	<c:otherwise>
		    	<li class="nav-item ">
		      <a class="nav-link" href="/home">Home</a>
					</li>
    		<li class="nav-item ">
      			<a class="nav-link" href="/loginPage">Log In</a>
    		</li>    
    		 <li><a class="nav-link" href="/registrationForm">Register</a></li>     					
    		<li class="nav-item ">
      			<a class="nav-link" href="/aboutUs">AboutUs</a>
    		</li>    
    	</c:otherwise>
    </c:choose>
    
  
</nav>
</html>