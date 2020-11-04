package com.wellsfargo.batch7.group3.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch7.group3.model.FundsTransfer;
import com.wellsfargo.batch7.group3.view.CustomerOperationsImpl;
import com.wellsfargo.batch7.group3.view.ICustomerDao;

/**
 * Servlet implementation class FundsTransfer
 */
@WebServlet("/transferFunds")
public class FundsTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICustomerDao custData;
	
	public void init(ServletConfig config) throws ServletException {
		custData = new CustomerOperationsImpl();
	}

    public FundsTransferController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		FundsTransfer fndsTrf = new FundsTransfer();
		
		fndsTrf.setCustAcctNum(Integer.parseInt(request.getParameter("fromAccount")));
		fndsTrf.setBnfcryAcctNum(Integer.parseInt(request.getParameter("toAccount")));
		fndsTrf.setBnfcryTrnsfrAmt(Double.parseDouble(request.getParameter("transferAmount")));
		fndsTrf.setBnfcryTxnType(request.getParameter("transferType"));
		fndsTrf.setBnfcryTxnComments(request.getParameter("txnComments"));
		
		fndsTrf = custData.transferFunds(fndsTrf);
		
		request.setAttribute("fundsTrf", fndsTrf);
		
		if(fndsTrf.getTxnStatus().contains("Success")) {
			request.getRequestDispatcher("fund_transfer_success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("fund_transfer_fail.jsp").forward(request, response);
		}
	
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
