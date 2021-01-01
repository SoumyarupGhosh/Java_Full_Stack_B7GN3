package com.wellsfargo.batch7.group3.ibs.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerTransactions;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderAccount;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderTransactionInfo;

@Repository
public interface ServiceProviderTransactionInfoRepo extends JpaRepository<ServiceProviderTransactionInfo, Long>{
	
	List<ServiceProviderTransactionInfo> findAllByServiceProviderId (String serviceProviderId);//fromCustomerUci
	List<ServiceProviderTransactionInfo> findAllByFromCustomerAccount (Long fromCustomerAccount);//fromCustomerUci
//s.txnId,s.toServicePrvider,s.fromCustomerUci,s.txnType,s.s.txnDateTime,s.txnCmnts
	
	ServiceProviderTransactionInfo findAllByServiceProvideraccountId (Long serviceProvideraccountId);//fromCustomerUci
	
	@Query(value="select s.txn_id,s.payment_amt,s.service_provider_id,s.from_customer_account,s.txn_type,s.txn_cmnts,s.txn_date_time from service_provider_transaction_info s where s.service_provider_id=?1 and s.from_customer_account=?2" ,nativeQuery=true)
	List<ServiceProviderTransactionInfo> findAllByFromCustomerAccount (String serviceProviderId,Long fromCustomerAccount);
	
	boolean existsByFromCustomerAccount(Long fromCustomerAccount);
	
	
	
	@Query(value="select s.txn_id,s.payment_amt,s.service_provider_id,s.from_customer_account,s.txn_type,s.txn_cmnts,s.txn_date_time from service_provider_transaction_info s where s.service_provider_id=:serviceProviderId and s.txn_date_time between :from and :to " ,nativeQuery=true)
	List<ServiceProviderTransactionInfo> findAllByFromTxnDateTime( String serviceProviderId, LocalDate from, LocalDate to);
	//List<ServiceProviderTransactionInfo> findAllByFromTxnDateTime(@Param("toServicePrvider") Long toServicePrvider,@Param("from") LocalDate from,@Param("to") LocalDate to);
	
	
	List<ServiceProviderTransactionInfo> findByFromCustomerAccountAndServiceProviderIdAndTxnDateTimeBetween(Long fromCustomerAccount,String serviceProviderId
			,LocalDate startTxnDateTime, LocalDate endTxnDateTime);
	
	List<ServiceProviderTransactionInfo> findByServiceProvideraccountIdAndTxnDateTimeBetween(Long serviceProvideraccountId
			,LocalDate startTxnDateTime, LocalDate endTxnDateTime);
}
