package com.GRH.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Formation {

    @Id
    private Long id;
    private String topic;
    private String description;
    private String duration;
    private int nbStudent;
    @OneToMany(mappedBy = "formation")
    private List<Employee> employees;
    @ManyToOne
    private Admin admin;

}
