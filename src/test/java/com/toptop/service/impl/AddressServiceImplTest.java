package com.toptop.service.impl;

import com.toptop.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
class AddressServiceImplTest {

    private AddressService addressService;

    @Before
    void setUp() {
        addressService = new AddressServiceImpl();
    }

    @Test
    public void shouldSave() throws Exception {
        addressService.save(null);
    }
}
