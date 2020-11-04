package com.wellsfargo.batch7.group3.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch7.group3.model.RegistrationProcess;
import com.wellsfargo.batch7.group3.view.CustomerOperationsImpl;
import com.wellsfargo.batch7.group3.view.ICustomerDao;
import com.wellsfargo.batch7.group3.view.IVerifyKYC;
import com.wellsfargo.batch7.group3.view.KYCImpl;

@WebServlet("/regForm")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();
    }

    private IVerifyKYC userKYC;
    public void init(ServletConfig config) throws ServletException {
    	userKYC = new KYCImpl();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession session = request.getSession();
		//ServletContext context = getServletContext();
		RegistrationProcess regProcess = new RegistrationProcess();
		
		regProcess.setFirstname(request.getParameter("firstName"));
		regProcess.setLastname(request.getParameter("lastName"));
		regProcess.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
		System.out.println("**"+regProcess.getDateOfBirth());
		regProcess.setGender(request.getParameter("gender"));
		regProcess.setEmailId(request.getParameter("emailId"));
		regProcess.setMobileNum(request.getParameter("mobileNum"));
		regProcess.setAddress(request.getParameter("address"));
		regProcess.setCity(request.getParameter("city"));
		regProcess.setPinCode(Integer.parseInt(request.getParameter("pinCode")));
		regProcess.setAddress(request.getParameter("typOfAcct"));
		System.out.println("typOfAcct:"+request.getParameter("typOfAcct"));
		
		if(request.getParameter("typOfAcct").equalsIgnoreCase("Customer")) {
			String[] names = request.getParameterValues("custAcctType");
			regProcess.setCustAcctType(Arrays.asList(names));
			//System.out.println("**"+regProcess.getCustAcctType());
		}
		regProcess.setKycIdentityType(request.getParameter("kycUploadType"));
		
		regProcess = userKYC.registerNewUser(regProcess);
		
		request.setAttribute("userReg", regProcess);
		request.getRequestDispatcher("regComplete.jsp").forward(request, response);
	
	}			


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
