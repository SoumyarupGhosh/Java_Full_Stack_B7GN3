<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funds Transfer - Add Beneficiary</title>
</head>
<body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0" bgcolor="#FFFFFF" style="background-color:PaleGoldenRod;">
	<h1 style="text-align:center;background-color:DarkCyan;color:White;font-size:45">IBS Bank</h1>

<form>
	<table border="0" cellspacing="0" cellpadding="0" width="30%" >
			<tr><td><strong>Beneficiary Account Number </strong></td> 
			<td><em><input type="text" name="bnfcryAcctNum" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Account Name </strong></td> 
			<td><em><input type="text" name="bnfcryName" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Bank</strong></td> 
			<td><em><input type="date" name="bnfcryBank" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary IFSC</strong></td> 
			<td><em><input type="text" name="bnfcryIfsc" required /></em></td>
			</tr>
			<tr><td><strong>Transaction Type</strong></td> 
			<td><em><input type="text" name="bnfcryTxnType" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Mobile #</strong></td> 
			<td><em><input type="text" name="bnfcryMobileNum" required /></em></td>
			</tr>
			<tr><td align="center"><button>Submit</button></td> 
			<td><em></em></td>
			</tr>
</table>
</form>
    </body>
</html>