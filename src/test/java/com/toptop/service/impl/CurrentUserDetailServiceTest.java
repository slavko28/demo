package com.toptop.service.impl;

import com.toptop.domain.CurrentUser;
import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CurrentUserDetailServiceTest {

    @TestConfiguration
    static class CurrentUserDetailServiceTestContextConfiguration {

        @Bean
        public UserDetailsService userDetailsService() {
            return new CurrentUserDetailService();
        }
    }

    private String email = "user@mail";
    private UserRole role = UserRole.MANAGER;

    private CurrentUser currentUser;

    @MockBean
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setEmail(email);
        user.setPassword("password");
        user.setRole(role);
        currentUser = new CurrentUser(user);

        when(userService.getUserByEmail(email)).thenReturn(Optional.of(user));
    }

    @Test()
    public void loadUserByUsername() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        Assert.assertNotNull(userDetails);
        Assert.assertEquals(this.currentUser, userDetails);
        userDetailsService.loadUserByUsername("neverFind@mail");
    }

}