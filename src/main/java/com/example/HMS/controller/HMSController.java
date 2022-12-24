package com.example.HMS.controller;

import com.example.HMS.model.Doctor;
import com.example.HMS.model.Patient;
import com.example.HMS.repo.DoctorRepository;
import com.example.HMS.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://hmsvarshifrontend.s3-website-us-east-1.amazonaws.com")
public class HMSController {

  @Autowired
  DoctorRepository doctorRepository;

  @Autowired
  PatientRepository patientRepository;

  static String patname;

  @PostMapping("/postDoctor")
  public void postDoctor(@RequestBody Doctor doctor){
    doctorRepository.save(doctor);

  }

  @GetMapping("/getDoctor")
  public List<Doctor> getDoctor(){
    return doctorRepository.findAll();
  }

  @PostMapping("/postPatient")
  public Patient postPatient(@RequestBody Patient patient){
    patname=patient.patientName;
    return patientRepository.save(patient);
  }

  @PostMapping("/assignDoctor")
  public Doctor assignDoctor(@RequestBody Doctor doctor){
    String docname=doctor.doctorName;
    List<Doctor> doclist = doctorRepository.findAll();
    Doctor d1=new Doctor();
    for(Doctor d: doclist){
      if(docname.equals(d.doctorName)){
          d1=d;
      }

      Patient patient = patientRepository.findByPatientName(patname);
      d1.patient.add(patient);
    }
    doctorRepository.save(d1);
    return d1;
  }


  @GetMapping("/getPatient")
  public List<Patient> getPatient(){
    return patientRepository.findAll();
  }
}
