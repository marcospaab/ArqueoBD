package com.arqueobd.arqueobdrf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Director {

    @Id
    @SequenceGenerator(
            name="director_sequence",
            sequenceName = "director_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "director_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long directorId;
    private String firstName;
    private String lastName;
}
