package com.ania.domain;

public class Registration {
    private int id;
    private int idStudent;
    private int idUniversity;
    private double studentFee;
    private int studentYear;

    public Registration() { }

    public Registration(int id, int idStudent, int idUniversity, double studentFee, int studentYear) {
        super();
        this.id = id;
        this.idStudent = idStudent;
        this.idUniversity = idUniversity;
        this.studentFee = studentFee;
        this.studentYear = studentYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
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
        return "Registration [id=" + id + ", idStudent=" + idStudent + ", idUniversity=" + idUniversity
                + ", studentFee=" + studentFee + ", studentYear=" + studentYear + "]";
    }

}
