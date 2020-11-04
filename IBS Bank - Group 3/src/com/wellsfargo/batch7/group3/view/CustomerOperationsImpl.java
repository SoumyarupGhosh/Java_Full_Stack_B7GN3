package com.wellsfargo.batch7.group3.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wellsfargo.batch7.group3.controller.DBConnection;
import com.wellsfargo.batch7.group3.model.Attributes;
import com.wellsfargo.batch7.group3.model.CustomerOperations;
import com.wellsfargo.batch7.group3.model.FundsTransfer;
import com.wellsfargo.batch7.group3.model.IBSException;

public class CustomerOperationsImpl implements ICustomerDao {

	@Override
	public CustomerOperations custLogin(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations firstTimeLogin(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations checkBalance(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations addBeneficiary(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations updateBeneficiary(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations viewStatement(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations payUtilBills(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations txnProcess(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations applyLoan(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations loanDetails(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations applyCard(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations cardDetails(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations reportLostCard(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOperations reqCardStatement(CustomerOperations custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FundsTransfer transferFunds(FundsTransfer fndsTrf) {
		Double avlblBal = getAvailableBalance(fndsTrf.getCustAcctNum());
		if(fndsTrf != null) {
			if (fndsTrf.getBnfcryTrnsfrAmt() > avlblBal) {
				fndsTrf.setTxnStatus("Transfer amount is greater than your available balance !! ");
			} else {
				fndsTrf.setTxnStatus("Transfer Successful");
			}
		}
		return fndsTrf;
	}

	private Double getAvailableBalance(Integer custAcctNum) {
		if(custAcctNum!= null) {
			try(Connection conn = DBConnection.getConn(); 
					PreparedStatement ps = conn.prepareStatement(Attributes.GET_ACCT_BALANCE)){
				ps.setInt(1, custAcctNum);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	
}