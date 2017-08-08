package com.toptop.repository;

import com.toptop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by slavkosoltys on 30.07.17.
 */
public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);

}
