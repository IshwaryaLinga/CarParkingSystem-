package com.it.car.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.car.domain.UserCarInfo;

@Repository
public interface UserCarInfoRepository extends PagingAndSortingRepository<UserCarInfo, Long>,JpaSpecificationExecutor<UserCarInfo>{
	
	@Query(value = "select uci.userId from UserCarInfo uci where lower(uci.licensePlateNumber)=:licensePlateNumber")
	Long validateUserCar(@Param("licensePlateNumber") String licensePlateNumber);
	
	@Query(value = "select uci from UserCarInfo uci where id in (:carIds)")
	List<UserCarInfo> getCarInfosByIds(@Param("carIds") Set<Long> carIds);
	
}
