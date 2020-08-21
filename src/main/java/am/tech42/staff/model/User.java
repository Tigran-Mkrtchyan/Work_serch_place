package am.tech42.staff.model;

public class User {
    private String id ;
    private String type;

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public User(String id, String type , String name) {
        this.id = id;
        this.type = type;
        this.name =name;
    }
}
