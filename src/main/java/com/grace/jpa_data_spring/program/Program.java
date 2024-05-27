package com.grace.jpa_data_spring.program;

import jakarta.persistence.*;

@Entity
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long program_id;

    @Column(nullable = false)
    private String program_name;

    @Column(nullable = false)
    private Integer duration;

    public Program() {
    }

    public Program(Long program_id, String program_name, Integer duration) {
        this.program_id = program_id;
        this.program_name = program_name;
        this.duration = duration;
    }

    public Long getProgram_id() {
        return program_id;
    }

    public void setProgram_id(Long program_id) {
        this.program_id = program_id;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
