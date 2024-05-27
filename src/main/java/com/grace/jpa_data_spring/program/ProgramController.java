package com.grace.jpa_data_spring.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramController {
    @Autowired
    private ProgramRepository programRepository;

    @GetMapping
    public ResponseEntity<List<Program>> getAllPrograms(){
        List<Program> program = programRepository.findAll();
        return ResponseEntity.ok(program);
    }

    @GetMapping("/{program_id}")
    public ResponseEntity<Optional<Program>> getProgramById(@PathVariable Long program_id){
        Optional<Program> oneProgram = programRepository.findById(program_id);
        return ResponseEntity.ok(oneProgram);
    }

    @PostMapping("/create")
    public ResponseEntity<Program> createProgram(@RequestBody Program data){
        var program = programRepository.save(data);
        return  ResponseEntity.ok(program);
    }

    @DeleteMapping("/delete/{program_id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long program_id){
        programRepository.deleteById(program_id);
        return ResponseEntity.ok("program was deleted");
    }
}
