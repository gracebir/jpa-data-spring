package com.grace.jpa_data_spring.fee;

import com.grace.jpa_data_spring.course.Course;
import com.grace.jpa_data_spring.student.Student;
import jakarta.persistence.*;

import javax.xml.crypto.Data;

@Entity
@Table(name = "fees")
public class Fee {
    @Id
    @GeneratedValue
    private Long fee_id;

    private Double amount;
    private Data due_date;

    @Enumerated(EnumType.STRING)
    private Status payment_status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Fee() {
    }

    public Fee(Long fee_id, Double amount, Data due_date, Status payment_status, Student student) {
        this.fee_id = fee_id;
        this.amount = amount;
        this.due_date = due_date;
        this.payment_status = payment_status;
        this.student = student;
    }

    public Long getFee_id() {
        return fee_id;
    }

    public void setFee_id(Long fee_id) {
        this.fee_id = fee_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Data getDue_date() {
        return due_date;
    }

    public void setDue_date(Data due_date) {
        this.due_date = due_date;
    }

    public Status getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Status payment_status) {
        this.payment_status = payment_status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
