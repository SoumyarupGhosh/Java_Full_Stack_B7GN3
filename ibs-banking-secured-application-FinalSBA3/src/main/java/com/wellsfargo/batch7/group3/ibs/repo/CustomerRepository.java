package com.wellsfargo.batch7.group3.ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;




@Repository
public interface CustomerRepository extends JpaRepository<CustomerAccount, Long>{


	List<CustomerAccount> findByRegId(Long regId);

	@Query(value="select user_name  from cust_acct where uci=?1" ,nativeQuery=true)
	String findByName(String uci);
	
	CustomerAccount findByUci(String uci);
	boolean existsByUci(String uci);
//	List<CustomerAccount> findByCustAcctType(String custAcctType);

//	List<CustomerAccount> findByCustAcctNum(Long fromAcctNum);


}
