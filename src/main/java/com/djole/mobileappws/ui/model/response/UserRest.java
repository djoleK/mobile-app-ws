package com.djole.mobileappws.ui.model.response;

public class UserRest {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;

    public UserRest() {
    }

    public UserRest(String userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRest userRest = (UserRest) o;

        if (userId != null ? !userId.equals(userRest.userId) : userRest.userId != null) return false;
        if (firstName != null ? !firstName.equals(userRest.firstName) : userRest.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userRest.lastName) : userRest.lastName != null) return false;
        return email != null ? email.equals(userRest.email) : userRest.email == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRest{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
