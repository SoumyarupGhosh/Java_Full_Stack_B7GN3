<html>
	<head>
	 	<title>Employee Login</title>
	</head>
	<body style="background-color:PaleGoldenRod;">
	<h1 style="text-align:center;background-color:DarkCyan;color:White;font-size:45">IBS Bank - Login</h1>
<jsp:include page="homeMenu.jsp"/>


<h2>Welcome Back To IBS Bank</h2>
<table>
		<tr><td><strong>Employee ID&nbsp;&nbsp;</strong></td> 
		<td><em><input type="number" name="svcId" required /></em></td>
		</tr>
		<tr><td><strong>Password&nbsp;&nbsp;</strong></td> 
		<td><em><input type="password" name="password" required /></em></td>
		</tr>
		<tr><td align="center"><button>Submit</button></td> 
		<td><em></em></td>
		</tr>
</table>
</body>
</html>