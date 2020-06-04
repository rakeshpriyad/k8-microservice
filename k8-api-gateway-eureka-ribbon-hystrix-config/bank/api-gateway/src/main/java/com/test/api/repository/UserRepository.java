package com.test.api.repository;

import com.test.api.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT email FROM User user ORDER BY user.email")
    User findByEmail(String email);
}
