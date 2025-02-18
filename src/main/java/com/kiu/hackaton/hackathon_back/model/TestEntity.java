package com.kiu.hackaton.hackathon_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    
    @Id
    private Long id;

    private String testAttribute;
}
