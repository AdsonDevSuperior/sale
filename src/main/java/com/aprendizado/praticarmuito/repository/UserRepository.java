package com.aprendizado.praticarmuito.repository;

import com.aprendizado.praticarmuito.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
