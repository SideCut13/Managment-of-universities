package com.ania.domain;

public class University {
    private int id;
    private String name;
    private String city;
    private String address;
    private String email;
    private String telephoneNumber;
    private int year;

    public University() {  }

    public University(int id, String name, String city, String address, String email, String telephoneNumber,
                      int year) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "University [id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", email="
                + email + ", telephoneNumber=" + telephoneNumber + ", year=" + year + "]";
    }
}
