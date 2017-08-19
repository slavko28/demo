package com.toptop.service.impl;

import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.repository.UserRepository;
import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import com.toptop.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends TransactionService<User, Long, UserMapper, UserDTO> implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserWithRole(UserDTO userDTO, UserRole role) {
        User user = getMapper().map(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setActive(true);
        user.setRole(role);
        save(user);
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    protected UserMapper getMapper() {
        return userMapper;
    }
}
