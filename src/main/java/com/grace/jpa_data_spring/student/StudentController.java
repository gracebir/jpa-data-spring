package com.grace.jpa_data_spring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudents(){
        var students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Integer id){
        Optional<Student> student = studentRepository.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        var response = studentRepository.save(student);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student){
        Optional<Student> student1 = studentRepository.findById(id);
        var response = studentRepository.save(student);
        return ResponseEntity.ok(response);
    }
}
