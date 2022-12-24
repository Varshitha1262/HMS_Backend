package com.example.HMS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {


  @GeneratedValue(strategy= GenerationType.IDENTITY)
  public int patientId;

  @Id
  public String patientName;

  public String age;

  public String phoneNo;

}
