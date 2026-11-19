package com.univalle.demo.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "student") @Data @NoArgsConstructor @AllArgsConstructor
public class Student { @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; private String name; @Column(name = "last_name") private String lastName; private Integer age; private Boolean state; }