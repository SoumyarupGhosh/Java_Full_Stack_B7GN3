<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="serviceProviderHome.jsp"/>
<h5>Check Payment via Account</h5>
	<form action="CheckPaymnet" method="POST" >
			<div>
				<label>From Account </label>
				<input type="number" name="fromAccount"  />
			</div>					
			<div>
				<button>FetchDetail</button>
			</div>
			<h5>Check Payment via Date</h5>
	<form action="CheckPaymnet" method="POST" >
			<div>
				<label>On Date </label>
				<input type="date" name="OnDate"  />
			</div>					
			<div>
				<button>FetchDetail</button>
			</div>
	</form>
</body>
</html>