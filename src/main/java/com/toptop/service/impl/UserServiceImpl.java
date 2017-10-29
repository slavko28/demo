package com.toptop.service.impl;

import com.toptop.domain.User;
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

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl extends TransactionService<User, Long, UserMapper, UserDTO> implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserByEmail(String email) {
        LOG.debug("Searching user by email: {}", email);
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Optional<User> getUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userDTO.setActive(false);
        LOG.debug("Save user with name: {}", userDTO.getName());
        save(userDTO);
    }

    @Override
    public void update(UserDTO userDTO) {
        LOG.debug("Updating user with id: {}", userDTO.getId());
        User userFromBase = getRepository().getOne(userDTO.getId());
        userFromBase.setName(userDTO.getName());
        userFromBase.setLastName(userDTO.getLastName());
        userFromBase.setPhoneNumber(userDTO.getPhoneNumber());
        userFromBase.setRole(userDTO.getRole());
        userFromBase.setActive(userDTO.getActive());
        getRepository().save(userFromBase);
    }

    @Override
    public String createResetToken(User user) {
        LOG.debug("Preparing token to password reset");
        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(2);
        user.setExpiryDate(expiryDate);
        userRepository.save(user);
        return token;
    }

    @Override
    public void resetPassword(User user, String password) {
        LOG.debug("Reset password by user {}", user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(password));
        LOG.debug("Reset token");
        user.setResetToken(null);
        getRepository().save(user);
    }

    @Override
    public boolean checkToken(String token) {
        LOG.debug("Checking if token: {} - is valid", token);
        Optional<User> maybeUser = userRepository.findByResetToken(token);
        if (!maybeUser.isPresent()) {
            return false;
        }
        User user = maybeUser.get();
        return LocalDateTime.now().isBefore(user.getExpiryDate());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(UserDTO userDTO) throws IllegalArgumentException{
        LOG.debug("Check if user is exits: {}", userDTO);
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
