package com.junit;
import java.util.regex.Pattern;

public class UserRegistration {

    public boolean validateUsername(String username) {
        return username != null && username.matches("[A-Za-z]{3,}");
    }

    public boolean validatePassword(String password) {
        return password != null && password.matches("(?=.*\\d).{6,}");
    }

    public boolean validateEmail(String email) {
        return email != null && Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }
}
