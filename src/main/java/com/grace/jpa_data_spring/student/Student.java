package com.grace.jpa_data_spring.student;

import com.grace.jpa_data_spring.fee.Fee;
import com.grace.jpa_data_spring.program.Program;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private  String lastname;

    @Column(unique = true)
    private String email;
    private Date birth_date;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String phone_number;

    private String address;

    private Date enrollment_date;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "student")
    private List<Fee> feeList;

    public Student(){}

    public Student(Integer id, String firstname, String lastname, String email, Date birth_date, Gender gender, String phone_number, String address, Date enrollment_date, Program program, List<Fee> feeList) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birth_date = birth_date;
        this.gender = gender;
        this.phone_number = phone_number;
        this.address = address;
        this.enrollment_date = enrollment_date;
        this.program = program;
        this.feeList = feeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Gender getGender() {
        return gender;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public List<Fee> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<Fee> feeList) {
        this.feeList = feeList;
    }
}
