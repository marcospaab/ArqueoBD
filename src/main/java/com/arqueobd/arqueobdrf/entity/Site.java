package com.arqueobd.arqueobdrf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;
    private String coordinates;
    private String code;
}
