package com.javaseventeen.learning.service;

import com.javaseventeen.learning.model.Doctor;
import com.javaseventeen.learning.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id){
        return doctorRepository.findById(id);
    }

//    @Override
//    public Doctor updateDoctor(Doctor doctor, Long id) {
//        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(id);
//
//        if (existingDoctorOpt.isPresent()) {
//            Doctor existingDoctor = existingDoctorOpt.get();
//
//            existingDoctor.setFirstName(doctor.getFirstName());
//            existingDoctor.setLastName(doctor.getLastName());
//            existingDoctor.setSpecialty(doctor.getSpecialty());
//            existingDoctor.setSubSpecialty(doctor.getSubSpecialty());
//            existingDoctor.setMedicalSchool(doctor.getMedicalSchool());
//            existingDoctor.setGraduationYear(doctor.getGraduationYear());
//            existingDoctor.setEmail(doctor.getEmail());
//            existingDoctor.setPhone(doctor.getPhone());
//            existingDoctor.setPracticeName(doctor.getPracticeName());
//            existingDoctor.setAddress(doctor.getAddress());
//            existingDoctor.setCity(doctor.getCity());
//            existingDoctor.setProvince(doctor.getProvince());
//            existingDoctor.setLicenseNumber(doctor.getLicenseNumber());
//            existingDoctor.setBoardCertifications(doctor.getBoardCertifications());
//            existingDoctor.setLanguagesSpoken(doctor.getLanguagesSpoken());
//            existingDoctor.setYearsOfExperience(doctor.getYearsOfExperience());
//            existingDoctor.setIsAcceptingNewPatients(doctor.getIsAcceptingNewPatients());
//            existingDoctor.setInsuranceAccepted(doctor.getInsuranceAccepted());
//            existingDoctor.setIsVerified(doctor.getIsVerified());
//
//            return doctorRepository.save(existingDoctor);
//        } else {
//            throw new RuntimeException("Doctor not found with id: " + id);
//        }
//    }

    @Override
    public void deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
    }
}
