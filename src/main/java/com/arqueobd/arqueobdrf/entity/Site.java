package com.arqueobd.arqueobdrf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

//clase site para marcar como entidad en tabla de yacimientos
@Entity
@Table(name = "sites")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Site {
    //primary key es el id, se genera automaticamente en la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Por favor, añada un nombre para el yacimiento.")
    private String name;
    private String coordinates;
    @Length(min = 2, max=10, message = ("El tamaño del código del yacimiento debe estar entre 2 y 10 dígitos."))
    @NotBlank(message = "Por favor, añada un código para el yacimiento.")
    private String code;
}
