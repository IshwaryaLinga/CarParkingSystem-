package com.it.car.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.car.domain.VehicleNoParkingInfo;

@Repository
public interface CarOwnerPaymentRepository extends PagingAndSortingRepository<VehicleNoParkingInfo, Long>,JpaSpecificationExecutor<VehicleNoParkingInfo>{
	
	@Transactional
	@Modifying
	@Query(value = "update VehicleNoParkingInfo SET paid=:paid, due=:due Where id=:id")
	void updatePaidAndDue(@Param("id") long id, @Param("paid") BigDecimal paid,@Param("due") BigDecimal due);
	
}
