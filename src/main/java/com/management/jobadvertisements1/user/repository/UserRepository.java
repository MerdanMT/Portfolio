package com.management.jobadvertisements1.user.repository;

import com.management.jobadvertisements1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUsersById(Long id);

    List<User> getUsersByIsActiveTrue();

    List<User> getUsersByRegionLikeIgnoreCase(String region);

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
