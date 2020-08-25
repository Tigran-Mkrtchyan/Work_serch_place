package am.tech42.staff.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private Date birthday;
    private String address;

    @Transient
    private String phoneNumber;

    @Column (name = "cv_url")
    private String cvUrl;
    @Column (name = "img_url")
    private String imgUrl;
    @Transient
    private int age ;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCvPath(String cvPath) {
        this.cvUrl = cvPath;
    }

    public void setImgPath(String imgPath) {
        this.imgUrl = imgPath;
    }

    public String getCvPath() {
        return cvUrl;
    }

    public String getImgPath() {
        return imgUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void evaluateAgeFromBirthday(){
        java.util.Date date = new java.util.Date(birthday.getTime());
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(date);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        this.age = currentYear - calendar.get(Calendar.YEAR);
    }
    public Employee(){
    }
    public Employee(String userId, String firstName, String lastName, Date birthday) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

}
