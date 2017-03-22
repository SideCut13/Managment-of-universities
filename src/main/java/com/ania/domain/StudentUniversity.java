package com.ania.domain;

public class StudentUniversity {
    private int id;
    private String studentName;
    private String surname;
    private int age;
    private String studentAddress;
    private String studentEmail;
    private String universityName;
    private String city;
    private String universityAddress;
    private String universityEmail;
    private String telephoneNumber;
    private int year;
    private double studentFee;
    private int studentYear;

    public StudentUniversity() {  }

    public StudentUniversity(int id, String studentName, String surname, int age, String studentAddress,
                             String studentEmail, String universityName, String city, String universityAddress, String universityEmail,
                             String telephoneNumber, int year, double studentFee, int studentYear) {
        super();
        this.id = id;
        this.studentName = studentName;
        this.surname = surname;
        this.age = age;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
        this.universityName = universityName;
        this.city = city;
        this.universityAddress = universityAddress;
        this.universityEmail = universityEmail;
        this.telephoneNumber = telephoneNumber;
        this.year = year;
        this.studentFee = studentFee;
        this.studentYear = studentYear;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getStudentAddress() {
        return studentAddress;
    }
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getUniversityAddress() {
        return universityAddress;
    }
    public void setUniversityAddress(String universityAddress) {
        this.universityAddress = universityAddress;
    }
    public String getUniversityEmail() {
        return universityEmail;
    }
    public void setUniversityEmail(String universityEmail) {
        this.universityEmail = universityEmail;
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
    public double getStudentFee() {
        return studentFee;
    }
    public void setStudentFee(double studentFee) {
        this.studentFee = studentFee;
    }
    public int getStudentYear() {
        return studentYear;
    }
    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

    @Override
    public String toString() {
        return "StudentUniversity [id=" + id + ", studentName=" + studentName + ", surname=" + surname + ", age=" + age
                + ", studentAddress=" + studentAddress + ", studentEmail=" + studentEmail + ", universityName="
                + universityName + ", city=" + city + ", universityAddress=" + universityAddress + ", universityEmail="
                + universityEmail + ", telephoneNumber=" + telephoneNumber + ", year=" + year + ", studentFee="
                + studentFee + ", studentYear=" + studentYear + "]";
    }
}
