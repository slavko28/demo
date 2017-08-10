package com.toptop.service.impl;

import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.repository.UserRepository;
import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import com.toptop.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

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
        User user = userMapper.map(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setActive(true);
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findOne(Long id) {
        return userMapper.map(userRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return userMapper.mapToUserDTOList(userRepository.findAll());
    }

}
