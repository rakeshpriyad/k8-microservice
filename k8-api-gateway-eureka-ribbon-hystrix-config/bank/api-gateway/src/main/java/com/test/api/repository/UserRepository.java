package com.test.api.repository;

import com.test.api.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("FROM User user WHERE user.ssoId = :ssoId")
    Optional<User> findBySSoId(@Param("ssoId") String ssoId);
}
