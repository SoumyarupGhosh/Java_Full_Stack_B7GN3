package com.wellsfargo.batch7.group3.view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wellsfargo.batch7.group3.controller.DBConnection;
import com.wellsfargo.batch7.group3.model.Attributes;
import com.wellsfargo.batch7.group3.model.IBSException;
import com.wellsfargo.batch7.group3.model.RegistrationProcess;

public class KYCImpl implements IVerifyKYC {
	@Override
	public RegistrationProcess registerNewUser(RegistrationProcess userReg) {
		
		try(Connection conn = DBConnection.getConn(); 
				PreparedStatement ps = conn.prepareStatement(Attributes.INS_KYC_DETAILS)){
			
			int reg_id_cntr = getMaxKYCRegId();
			int lenCustAcctTyp = userReg.getCustAcctType().size();
			
			for(int i=0; i < lenCustAcctTyp ; i++) {
				System.out.println("i:"+i);
				System.out.println("$$"+(String) userReg.getCustAcctType().get(i));
			ps.setInt(1, (reg_id_cntr+1));
			ps.setString(2, userReg.getFirstname());
			ps.setString(3, userReg.getLastname());
			ps.setString(4, userReg.getGender());
			ps.setDate(5, Date.valueOf(userReg.getDateOfBirth())); // 2020-01-01
			ps.setString(6, userReg.getEmailId());
			ps.setString(7, userReg.getMobileNum());
			ps.setString(8, userReg.getAddress());
			ps.setString(9, userReg.getCity());
			ps.setInt(10, userReg.getPinCode());
			ps.setString(11, userReg.getTypeOfAcctHolder());
			ps.setString(12, (String) userReg.getCustAcctType().get(i));
			ps.setString(13, userReg.getKycIdentityType());
			//ps.setString(14, userReg.getKycUploadDoc());//Doc1.jpeg default for now
			
			ps.executeUpdate();
			System.out.println("1 row inserted in KYC_DETAIL table ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	private int getMaxKYCRegId() {
		int maxKYCRegId = 0;
			try(Connection conn = DBConnection.getConn(); 
					PreparedStatement ps = conn.prepareStatement(Attributes.GET_MAX_KYC_REG_ID)){
				maxKYCRegId = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return maxKYCRegId;
	}

	@Override
	public RegistrationProcess validateKYC(RegistrationProcess regAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrationProcess createCustomerId(RegistrationProcess custAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrationProcess createServiceProviderId(RegistrationProcess svcAcct) throws IBSException {
		// TODO Auto-generated method stub
		return null;
	}
}