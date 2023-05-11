package models;

import models.annotations.JsonKey;
import models.annotations.Jsonable;
import models.annotations.JsonParser;

@Jsonable
public class User {
    @JsonKey(value = "email")
    private String email;
    @JsonKey(value = "name", composedKey = true, separator = " ")
    private String firstName;
    @JsonKey(value = "lastName", composedKey = true)
    private String lastName;
    private Integer age;
    private String password;

    public User(String email, String firstName, String lastName, Integer age, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonParser
    private void nameParser() {
        this.firstName = firstName.substring(0, 1).toUpperCase()
                + firstName.substring(1).toLowerCase();

        this.lastName = lastName.substring(0, 1).toUpperCase()
                + lastName.substring(1).toLowerCase();
    }

    @JsonParser
    private void emailParser() {
        this.email = email.substring(0, 1).toUpperCase()
                + email.substring(1).toLowerCase();
    }

}
