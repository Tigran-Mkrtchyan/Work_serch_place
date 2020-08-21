package am.tech42.staff.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String phoneNumber;
    private String cvPath;
    private String imgPath;
    private String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCvPath() {
        return cvPath;
    }

    public String getImgPath() {
        return imgPath;
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

    public Employee(String firstName, String lastName, java.sql.Date birthday) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday.toString();
        this.age = getAgeFromBirthday(birthday);

    }
    private int getAgeFromBirthday( java.sql.Date birthday){
        java.util.Date date = new java.util.Date(birthday.getTime());
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(date);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - calendar.get(Calendar.YEAR);
    }
}