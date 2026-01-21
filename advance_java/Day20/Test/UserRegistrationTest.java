package com.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration userReg = new UserRegistration();

    @Test
    public void givenValidUsername_ShouldReturnTrue() {
        assertTrue(userReg.validateUsername("Kishor"));
    }

    @Test
    public void givenInvalidUsername_ShouldReturnFalse() {
        assertFalse(userReg.validateUsername("Ki")); // too short
    }

    @Test
    public void givenValidPassword_ShouldReturnTrue() {
        assertTrue(userReg.validatePassword("abc123"));
    }

    @Test
    public void givenInvalidPassword_ShouldReturnFalse() {
        assertFalse(userReg.validatePassword("abcdef")); // no digit
    }

    @Test
    public void givenValidEmail_ShouldReturnTrue() {
        assertTrue(userReg.validateEmail("bharati@gmail.com"));
    }

    @Test
    public void givenInvalidEmail_ShouldReturnFalse() {
        assertFalse(userReg.validateEmail("bharati.com")); // missing @
    }
}
