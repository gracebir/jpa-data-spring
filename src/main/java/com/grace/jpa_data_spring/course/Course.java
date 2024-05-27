package com.grace.jpa_data_spring.course;

import com.grace.jpa_data_spring.program.Program;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    @Column(nullable = false)
    private String course_name;

    @Column(nullable = false, unique = true)
    private String course_code;
    @Column(nullable = false)
    private Integer credits;


    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    public Course() {
    }

    public Course(Long course_id, String course_name, String course_code, Integer credits, Program program) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_code = course_code;
        this.credits = credits;
        this.program = program;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
