package com.javaseventeen.learning.controller;

import com.javaseventeen.learning.model.Doctor;
import com.javaseventeen.learning.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorservice;

    @PostMapping("/create-doctor")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        System.out.println("Incoming doctor: " + doctor);
        doctorservice.saveDoctor(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    //read all operation
    @GetMapping("/")
    public List<Doctor> getAllDoctors(){
        return doctorservice.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){
        Optional<Doctor> doctor= doctorservice.findById(id);
        if(doctor.isPresent()){
            return ResponseEntity.ok(doctor.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable("id") Long id){
//        doctorservice.updateDoctor(doctor, id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctor);
//    }

    //delete operation
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable("id") Long id){
        doctorservice.deleteDoctor(id);
        return "Deleted successfully";
    }
}
