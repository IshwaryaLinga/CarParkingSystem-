package com.it.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.it.car.domain.VehicleNoParkingInfo;

@Repository
public interface TrafficPoliceDueVehicleRepository extends PagingAndSortingRepository<VehicleNoParkingInfo, Long>,JpaSpecificationExecutor<VehicleNoParkingInfo>{
	
	@Query(value = "select vnpi from VehicleNoParkingInfo vnpi where vnpi.due is not null and vnpi.due>0")
	List<VehicleNoParkingInfo> getDueVehicles();
	
}
