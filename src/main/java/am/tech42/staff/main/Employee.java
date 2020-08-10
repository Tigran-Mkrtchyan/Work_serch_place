package am.tech42.staff.main;

//import java.sql.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private  String phoneNumber;

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

    public Employee(String firstName, String lastName, java.sql.Date birthday) {

        this.firstName = firstName;
        this.lastName = lastName;
        java.util.Date date = new java.util.Date(birthday.getTime());
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(date);
        this.age = calendar.get(Calendar.YEAR);
    }
}
