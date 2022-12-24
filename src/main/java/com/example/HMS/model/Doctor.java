package com.example.HMS.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

  @GeneratedValue(strategy= GenerationType.IDENTITY)
  public int doctorId;

  @Id
  public String doctorName;

  public String gender;

  public String phoneNo;

  @OneToMany(cascade = {CascadeType.ALL})
  @NotFound(action = NotFoundAction.IGNORE)
  public List<Patient> patient;


}
