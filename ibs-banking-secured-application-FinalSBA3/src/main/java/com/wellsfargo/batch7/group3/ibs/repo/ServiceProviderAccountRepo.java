package com.wellsfargo.batch7.group3.ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderAccount;

@Repository
public interface ServiceProviderAccountRepo extends JpaRepository<ServiceProviderAccount, Long>{
	
	ServiceProviderAccount findAllByServiceProviderId (String serviceProviderId);
	ServiceProviderAccount findAllByAccountId (Long accountId);

}
