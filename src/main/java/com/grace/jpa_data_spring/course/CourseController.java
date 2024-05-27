package com.grace.jpa_data_spring.course;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("")
    public ResponseEntity<List<Course>> getAllCourse(){
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getOnCourse(@PathVariable Long id){
        var course = courseRepository.findById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody @Valid Course data){
        var course = courseRepository.save(data);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course){
        Course existingCourse = courseRepository.findById(id).get();

        existingCourse.setCourse_name(course.getCourse_name());
        existingCourse.setCredits(course.getCredits());
        existingCourse.setCourse_code(course.getCourse_code());
        existingCourse.setProgram(course.getProgram());

        var updatedCourse = courseRepository.save(existingCourse);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        var course = courseRepository.findById(id);
        courseRepository.deleteById(id);
        return ResponseEntity.ok(String.format("Course %1$s has been deleted!!",course.get().getCourse_name()));
    }

}
