package com.example.HMS.repo;

import com.example.HMS.model.Doctor;
import com.example.HMS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
