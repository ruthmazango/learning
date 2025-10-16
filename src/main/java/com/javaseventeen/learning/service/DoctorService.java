package com.javaseventeen.learning.service;

import com.javaseventeen.learning.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Optional<Doctor> findById(Long id);

//    Doctor updateDoctor(Doctor doctor, Long id);

    void deleteDoctor(Long id);
}
