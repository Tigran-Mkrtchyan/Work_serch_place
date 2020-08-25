package am.tech42.staff.model;

import  am.tech42.staff.service.UserType;
public class User {
    private String id;
    private UserType userType;
    private String name;

    public User(String id, UserType userType, String name) {
        this.id = id;
        this.userType = userType;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
