package com.register.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column
   private String firstName;

   @Column
   private String lastName;
   @Column
   private String email;
  
   @Column
   private String phone;

   @Column
   private String password;
   
   public enum Gender{
	male,female;
}
   @Enumerated(EnumType.STRING)
   private Gender gender;
}
