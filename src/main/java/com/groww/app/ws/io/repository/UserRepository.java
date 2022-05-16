package com.groww.app.ws.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.groww.app.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
	
	
//	 native sql queries
	
	@Query(value="select * from users u where u.first_name=?1 and u.last_name=?2", nativeQuery = true)
	UserEntity findByFullName(String firstName, String lastName );

	@Query(value="select * from Users u where u.last_name = :lastName",nativeQuery=true)
	List<UserEntity> findUserByLastName(@Param("lastName") String lastName);
	
	@Query(value="select * from Users u where u.first_name = :firstName",nativeQuery=true)
	List<UserEntity> findUserByFirstName(@Param("firstName") String kuchbhi); // no need to mention the same object name
	
	
	
	@Modifying // update/delete query need Modifying annotation
    @Transactional 
    @Query("UPDATE UserEntity u set u.emailVerificationStatus =:emailVerificationStatus where u.userId = :userId")
    void updateUserEntityEmailVerificationStatus(
    		@Param("emailVerificationStatus") boolean emailVerificationStatus,
            @Param("userId") String userId);
	
	
	
	// JPQL (java persistence query language)
	
	@Query("select user from UserEntity user where user.userId =:userId")
	UserEntity findUserEntityByUserId(@Param("userId") String userId);
	
	@Query("select user.firstName, user.lastName from UserEntity user where user.userId =:userId")
	List<Object[]> getUserEntityFullNameById(@Param("userId") String userId);
	
    @Modifying
    @Transactional 
    @Query("UPDATE UserEntity u set u.emailVerificationStatus =:emailVerificationStatus where u.userId = :userId")
    void updateUserEntityEmailVerificationStatusJPQL(
    		@Param("emailVerificationStatus") boolean emailVerificationStatus,
            @Param("userId") String userId);
	
	
	
	
	
}
