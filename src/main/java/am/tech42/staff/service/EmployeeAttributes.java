package am.tech42.staff.service;

enum EmployeeAttributes {
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    BIRTHDAY("birthday"),
    PHONE_NUMBER("phone_number"),
    ADDRESS ("address");
 private  String value ;
 private EmployeeAttributes(String value){
     this.value = value;
 }
public String getValue(){
     return value;
}
}
