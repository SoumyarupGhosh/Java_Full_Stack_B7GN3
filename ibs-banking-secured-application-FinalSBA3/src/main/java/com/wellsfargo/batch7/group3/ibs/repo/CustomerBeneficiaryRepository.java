package com.wellsfargo.batch7.group3.ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerBeneficiary;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;
import com.wellsfargo.batch7.group3.ibs.model.CustomerBeneficiaryDto;




@Repository
public interface CustomerBeneficiaryRepository extends JpaRepository<CustomerBeneficiary, Long>{

	List<CustomerBeneficiary> findByCustAcctNum(Long custAcctNum);
	List<CustomerBeneficiary> findByUci(String uci);
	List<CustomerBeneficiary> findAllByCustAcctNumIn(List<Long> custAcctNum);
	List<CustomerBeneficiary> findAllByBnfcryStatus (String bnfcryStatus);
	
	boolean existsByBnfcryStatus (String bnfcryStatus);
	boolean existsByBnfcryId (Long bnfcryId);
	
	void deleteByBnfcryId (Long bnfcryId);

	
	CustomerBeneficiary findByBnfcryId (Long bnfcryId);
	//List<CustomerBeneficiary> findByUserName(String uci);
	
//	@Query(value="select count(*)  from cust_bnfcry where cust_acct_num=?1 and bnfcry_acct_num=?2" ,nativeQuery=true)
	Long countByCustAcctNumAndBnfcryAcctNum(Long custAcctNum,Long bnfcryAcctNum);


}
