package com.javaseventeen.learning.repository;
import com.javaseventeen.learning.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT a FROM Doctor a WHERE " +
            "LOWER(a.lastName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.firstName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.specialty) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.subSpecialty) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.medicalSchool) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Doctor> findDoctorsBySearchText(@Param("searchText") String searchText);

    List<Doctor> findByLastName(String lastName);

    List<Doctor> findByFirstName(String firstName);

    List<Doctor> findBySpecialty(String specialty);

    List<Doctor> findBySubSpecialty(String subSpecialty);

    List<Doctor> findByMedicalSchool(String medicalSchool);
}
