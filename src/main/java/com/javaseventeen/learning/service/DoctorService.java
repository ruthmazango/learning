package com.javaseventeen.learning.service;

import com.javaseventeen.learning.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);

//    List<Doctor> getAllDoctors();
    Page<Doctor> findAll(Pageable pageable);

    Optional<Doctor> findById(Long id);

//    Doctor updateDoctor(Doctor doctor, Long id);

    void deleteDoctor(Long id);

    List<Doctor> searchDoctors(String searchText);
}
