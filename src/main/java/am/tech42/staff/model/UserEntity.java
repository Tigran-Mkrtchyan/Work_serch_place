package am.tech42.staff.model;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class UserEntity {

    @Id
    @Column (name ="id" )
    private String id ;
    @Column(name = "type")
    private String type;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private  String email;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public UserEntity(){}


    public String getId() {
        return id;
    }



    public String getType() {
        return type;
    }
    public UserEntity(String id, String type, String email, String password) {
        this.id = id;
        this.type = type;
        this.password = password;
        this.email = email;
    }
}
