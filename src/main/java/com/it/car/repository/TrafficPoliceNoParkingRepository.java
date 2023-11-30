package com.it.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.it.car.domain.VehicleNoParkingInfo;

@Repository
public interface TrafficPoliceNoParkingRepository extends PagingAndSortingRepository<VehicleNoParkingInfo, Long>,JpaSpecificationExecutor<VehicleNoParkingInfo>{
	
	@Query(value = "SELECT puci.MAKE, puci.COLOR, puci.LICENSE_PLATE_NO, puci.MODEL, puci.STATE, puci.YEAR, pvnpi.CREATE_DATE, pvnpi.id,pui.username "
			+ "FROM POC_USER_INFO pui, POC_USER_CAR_INFO puci , POC_VEHICLE_NO_PARKING_INFO pvnpi "
			+ "WHERE pui.id=PUCI.USER_ID AND PUCI.id=pvnpi.CAR_ID "
			+ "AND pvnpi.DUE IS NULL", nativeQuery = true)
	List<Object[]> getNoParkingVehicles();
	
}
