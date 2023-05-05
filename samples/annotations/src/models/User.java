package models;

import annotations.InitializerParser;
import annotations.Printable;
import annotations.PrintableField;

import java.io.Serial;

@Printable
public class User {

    @PrintableField(key = "user")
    private String username;
    @PrintableField
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @InitializerParser
    private void parseNewUser() {
        username = "@" + username.toLowerCase();
        email = email.toLowerCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
