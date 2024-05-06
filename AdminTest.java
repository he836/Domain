package com.CMSC.Library.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AdminTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    @DirtiesContext
    public void testGetAuthorities() {
        // Save a sample admin to the database
        Admin admin = new Admin("John", "Doe", "john@example.com", "password", "1990-01-01", "123456789", "Address", "ADMIN");
        adminRepository.save(admin);

        // Retrieve the admin from the database
        Admin retrievedAdmin = adminRepository.findByEmail("john@example.com");

        // Test the getAuthorities method
        Collection<? extends GrantedAuthority> authorities = retrievedAdmin.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ADMIN")));
    }

    
}
