package com.example.entities;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="workers")
@Getter
@Setter
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "worker_gen")
    @SequenceGenerator(name = "worker_gen",sequenceName = "worker_seg",allocationSize = 1)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private int salary;
    private String address;
    private LocalDate dataOfBirth;
    @OneToMany
    private List<Pharmacy> pharmacyList;
}
