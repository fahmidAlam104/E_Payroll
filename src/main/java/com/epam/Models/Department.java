package com.epam.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department implements Serializable {

    @Column(unique = true)
    String name;
    String head;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dep_id")
    Long id;
    Long employeeCount;
    Double bonus;
}
