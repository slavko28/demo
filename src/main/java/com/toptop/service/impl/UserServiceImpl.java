package com.toptop.service.impl;

import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.repository.UserRepository;
import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import com.toptop.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends TransactionService<User, Long, UserMapper, UserDTO> implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        log.debug("Searching user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserWithRole(UserDTO userDTO, UserRole role) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userDTO.setActive(true);
        userDTO.setRole(role);
        log.debug("Save user with name: {}", userDTO.getName());
        save(userDTO);
    }

    @Override
    public boolean isExist(UserDTO userDTO) {
        return getRepository().exists(userDTO.getId());
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
