package com.grace.jpa_data_spring.fee;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fees")
public class FeeController {

    @Autowired
    private FeeRepository feeRepository;

    @PostMapping("/create")
    public ResponseEntity<Fee> createFee(@RequestBody @Valid Fee data){
        var fee = feeRepository.save(data);
        return ResponseEntity.ok(fee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fee> updateFee(@PathVariable Long id, @RequestBody Fee data){
        Fee fee = feeRepository.findById(id).get();

        fee.setAmount(data.getAmount());
        fee.setDue_date(data.getDue_date());
        fee.setPayment_status(data.getPayment_status());
        fee.setStudent(data.getStudent());

        var updatedFee = feeRepository.save(fee);
        return ResponseEntity.ok(updatedFee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFee(@PathVariable Long id){
        feeRepository.deleteById(id);
        return ResponseEntity.ok(String.format("This fee %1$s has been deleted!!!", id));
    }

    @GetMapping("")
    public ResponseEntity<List<Fee>> getAllFees(){
        return ResponseEntity.ok(feeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Fee>> getFeeById(@PathVariable Long id){
        return ResponseEntity.ok(feeRepository.findById(id));
    }
}
