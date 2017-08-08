package com.toptop.service.impl;

import com.toptop.domain.Role;
import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.repository.RoleRepository;
import com.toptop.repository.UserRepository;
import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import com.toptop.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserWithRole(User user, UserRole role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole(role.name());
        user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
        userRepository.save(user);
    }

    @Override
    public UserDTO findOne(Long id) {
        return userMapper.map(userRepository.findOne(id));
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

}
