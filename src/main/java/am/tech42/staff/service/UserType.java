package am.tech42.staff.service;

public enum UserType {
    COMPANY("company"),
    EMPLOYEE("employee");

    private String value;

   UserType(String value) {
    this.value = value;
    }

    public String getValue(){
        return value;
    }
}
