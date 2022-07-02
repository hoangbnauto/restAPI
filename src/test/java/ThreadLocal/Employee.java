package ThreadLocal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Employee {
    private String name;
    private int age;
    private boolean marrired;
    private String address;
    private String mobileNo;

    public Employee(){

    }
    public Employee(String name, int age, boolean marrired, String address, String mobileNo) {
        this.name = name;
        this.age = age;
        this.marrired = marrired;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarrired() {
        return marrired;
    }

    public void setMarrired(boolean marrired) {
        this.marrired = marrired;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
