package com.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="pharmacys")
@Getter
@Setter
@NoArgsConstructor


public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacy_gen")
    @SequenceGenerator(name = "pharmacy_gen", sequenceName = "pharmacy_seg", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "pharmacy",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Worker> workers;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Medicines> medicines;

}
