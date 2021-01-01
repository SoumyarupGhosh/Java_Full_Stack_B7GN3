package com.wellsfargo.batch7.group3.ibs.repo;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerTransactions;




@Repository
public interface CustomerTransactionsRepository extends JpaRepository<CustomerTransactions, Long>{

	List<CustomerTransactions> findByFromAcctNum(Long fromAcctNum);
	
	CustomerTransactions findAllByFromAcctNum(Long fromAcctNum);
	
//	List<CustomerTransactions> findByFromAcctNumAndTxnTypeOrToAcctNumAndTxnTypeAndTxnDateBetweenTxnDate(Long fromAcctNum,String txnType,Long to
//			AcctNum,String txnType);
	
//	@Query(value="select txn_id,from_acct_num,to_acct_num,txn_amt,txn_date,txn_mode,txn_type,uci,current_balance_eff_acct_num from cust_acct_txn_info where eff_acct_num=20201228153914 and txn_date between '2020-12-28' and '2020-12-29'",nativeQuery=true)
	
	List<CustomerTransactions> findByEffAcctNumAndTxnDateBetween(Long effAcctNum,LocalDate strartTxnDate, LocalDate endTxnDate);
			 		
			 		
	
	


}
