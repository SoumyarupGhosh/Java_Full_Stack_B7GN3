package com.wellsfargo.batch7.group3.ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;

@Repository
public interface KycDetailsRepo extends JpaRepository<KycDetails, Long>{
	
	KycDetails findByMobileNum(String mobileNum);
	KycDetails findByRegId(Long regId);
	
	boolean existsByMobileNum(String mobileNum);
	boolean existsByEmailId(String emailId);
	List<KycDetails> findAllByKycApproval (String kycApproval);
	boolean existsByKycApproval(String kycApproval);
	
	boolean existsByRegId(Long regId);

}
