<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>IBS Bank-Account Summary</title>
    </head>
   <body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0" bgcolor="#FFFFFF" style="background-color:PaleGoldenRod;">
	<h1 style="text-align:center;background-color:DarkCyan;color:White;font-size:45">IBS Bank</h1>
        
        <form name="acctSummary" >
            <table border="0" cellspacing="0" cellpadding="0">
                <tr><td>
                	<table border="0.5" >
                            <tr bgcolor="#FFF0FF">
                                <th align="center"><a href="Account_summary.jsp">Account Summary&nbsp;&nbsp;</a></th>
                                <th align="center"><a href="fixed_deposit.jsp">Fixed Deposit&nbsp;&nbsp;</a></th>
                                <th><a href="Account_summary.jsp">Account Summary&nbsp;&nbsp;</a></th>
                                <th><a href="Credit_card_payment.jsp">Recurring Deposit&nbsp;&nbsp;</a></th></tr>
                            <tr>
                            <tr align="right"><p>Welcome User !! </p></tr>
                        </table>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td bgcolor="#E3E4FA" height="410" width="24%" valign="top">
                        <br><strong>Services</strong><br>
                        <a href="accountSummary.jsp">Account Summary<br></a>
                        <a href="fundsTransfer.jsp">Funds Transfer<br></a>
                        <a href="accountStatement">Account Statement <br></a><br><br>
                        <a href="changePassword">Change Password<br></a>
                        <a href="index.jsp">Log out</a>
                        <br>
                        <br>
                    </td>
                    <td width="1100" height="100" bgcolor="#FAF8CC">
                        <font color="brown"><h2>Account Summary</h2></font>
                        <h3>Savings Account</h3>
                        <table border="1" >
                            <tr bgcolor="#98AFC7">
                                <th align="center">Account no</th>
                                <th align="center">Branch</th>
                                <th>Name</th>
                                <th>Currency</th>
                            	<th>Available Balance</th></tr>
                            <tr><td>balance</td>
                            	<td>branch</td>
                            	<td>name</td>
                                <td>INR</td>
                                <td>bal</td></tr>
                        </table>
                    </td>
                </tr>
            </table>
            <table border="0" cellspacing="0" cellpadding="0" width="100%">
            </table>

            <table border="0" cellspacing="0" cellpadding="0" width="100%" height="63" background="HTML/images/bot.gif">
                <tr>
                    <td>
                        <table border="0" cellspacing="0" cellpadding="0" width="780" background="" height="25">
                            <tr align="center" valign="top">
                                <td width="400"><h5 style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</h5><br/></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
