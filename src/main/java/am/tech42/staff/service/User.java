package am.tech42.staff.service;

public class User {
    private String id ;
    private String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public User(String id, String type) {
        this.id = id;
        this.type = type;
    }
}
