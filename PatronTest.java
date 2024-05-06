package com.CMSC.Library.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PatronTest {

    @Autowired
    private PatronRepository patronRepository;

    @Test
    public void testPatronConstructor() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        assertEquals("John", patron.getFirstName());
        assertEquals("Doe", patron.getLastName());
        assertEquals("john@example.com", patron.getEmail());
        assertEquals("password", patron.getPassword());
        assertEquals("1990-01-01", patron.getDateOfBirth());
        assertEquals("123 Main St", patron.getAddress());
    }

    @Test
    public void testPatronAuthorities() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        Collection<? extends GrantedAuthority> authorities = patron.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("PATRON")));
    }

    @Test
    public void testPatronUsername() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        assertEquals("john@example.com", patron.getUsername());
    }

    @Test
    public void testPatronIsCredentialsNonExpired() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        assertTrue(patron.isCredentialsNonExpired());
    }

    @Test
    public void testPatronIsAccountNonExpired() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        assertTrue(patron.isAccountNonExpired());
    }

    @Test
    public void testPatronIsAccountNonLocked() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        assertTrue(patron.isAccountNonLocked());
    }

    @Test
    public void testPatronIsEnabled() {
        Patron patron = new Patron("John", "Doe", "john@example.com", "password", "1990-01-01", "123 Main St");
        assertTrue(patron.isEnabled());
    }

    
}
