package com.wellsfargo.batch7.group3.ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;

@Repository
public interface CustomerAccountTypesInfoRepo extends JpaRepository<CustomerAccountTypesInfo, Long>{
	
	List<CustomerAccountTypesInfo> findAllByUci(String uci);
	
	List<CustomerAccountTypesInfo> findByUci(String uci);
	CustomerAccountTypesInfo findByCustomerAcctNum(Long customerAcctNum);
	
	List<CustomerAccountTypesInfo> findAllByCustAcctType(String custAcctType);
	
	boolean existsByCustomerAcctNum(Long customerAcctNum);
	
	List<CustomerAccountTypesInfo> findAllByCustomerAcctNum(Long customerAcctNum);
	

}

