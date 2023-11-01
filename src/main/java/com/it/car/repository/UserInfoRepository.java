package com.it.car.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.car.domain.UserInfo;

@Repository
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, Long>,JpaSpecificationExecutor<UserInfo>{
	
	@Query(value = "select count(*) from UserInfo ui where lower(ui.username)=:username")
	long validateUsername(@Param("username") String username);
	
	@Query(value = "select count(*) from UserInfo ui where ui.username=:username and ui.password=:password")
	long validateUser(@Param("username") String username, @Param("password") String password);
	
	@Query(value = "select ui from UserInfo ui where ui.id in (:userIds)")
	List<UserInfo> getUserInfoByIds(@Param("userIds") Set<Long> userIds);
	
}
