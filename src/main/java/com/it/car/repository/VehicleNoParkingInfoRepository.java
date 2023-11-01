package com.it.car.repository;


import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.car.domain.VehicleNoParkingInfo;

@Repository
public interface VehicleNoParkingInfoRepository extends PagingAndSortingRepository<VehicleNoParkingInfo, Long>,JpaSpecificationExecutor<VehicleNoParkingInfo>{
	
	@Query(value = "select vnpi from VehicleNoParkingInfo vnpi")
	List<VehicleNoParkingInfo> getNoAllNoParkingVehicles();
	
	@Transactional
	@Modifying
	@Query(value = "update VehicleNoParkingInfo SET fee=:fee, due=:due Where id=:id")
	void updateFeeAndDue(@Param("id") long id, @Param("fee") BigDecimal fee,@Param("due") BigDecimal due);
	
	@Query(value = "select vnpi from VehicleNoParkingInfo vnpi where vnpi.id=:id")
	VehicleNoParkingInfo getById(@Param("id") long id);
	
}
