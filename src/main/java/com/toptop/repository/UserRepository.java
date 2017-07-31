package com.toptop.repository;

import com.toptop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by slavkosoltys on 30.07.17.
 */
public interface UserRepository extends JpaRepository <User, Long> {
}
