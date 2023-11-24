package com.example.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name="medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicines_gen")
    @SequenceGenerator(name = "medicines_gen", sequenceName = "medicines_seg", allocationSize = 1)
    private Long id;
    private String name;
    @NotNull
    private int price;
    @ManyToMany(mappedBy = "medicines",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Pharmacy> pharmacies;
}



