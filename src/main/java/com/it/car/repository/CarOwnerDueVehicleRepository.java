package com.it.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.car.domain.VehicleNoParkingInfo;

@Repository
public interface CarOwnerDueVehicleRepository extends PagingAndSortingRepository<VehicleNoParkingInfo, Long>,JpaSpecificationExecutor<VehicleNoParkingInfo>{
	
	@Query(value = "SELECT puci.MAKE, puci.COLOR, puci.LICENSE_PLATE_NO, puci.MODEL, puci.STATE, puci.YEAR, "
			+ "pvnpi.FEE, pvnpi.PAID, pvnpi.DUE, pvnpi.CREATE_DATE "
			+ "FROM POC_USER_INFO pui, POC_USER_CAR_INFO puci , POC_VEHICLE_NO_PARKING_INFO pvnpi "
			+ "WHERE pui.id=PUCI.USER_ID AND PUCI.id=pvnpi.CAR_ID "
			+ "AND pui.USERNAME =:username AND pvnpi.DUE IS NOT NULL AND pvnpi.due >0", nativeQuery = true)
	List<Object[]> getDueVehicles(@Param("username") String username);
	
}
