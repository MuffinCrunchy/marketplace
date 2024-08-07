package com.muffincrunchy.marketplace.repository;

import com.muffincrunchy.marketplace.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
