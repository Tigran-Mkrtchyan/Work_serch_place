package am.tech42.staff.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="users")
public class UserEntity  {

    @Id
    @Column (name ="id" )
    private String id ;
    @OneToMany(mappedBy = "user")
    private Set<Company> companies = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<Employee> employees = new HashSet<>();
    @Column(name = "type")
    private String type;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private  String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
