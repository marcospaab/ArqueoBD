package com.arqueobd.arqueobdrf.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//mapeado de que es una tabla gracias al @Entity
@Entity
@Data //getter, setter y tostring
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( //permite cambiar datos sobre tablas y entidades
        name = "tbl_campaign",
        uniqueConstraints = @UniqueConstraint( //restricción para que el codigo de campaña sea unico
                name="code_unique",
                columnNames = "campaign_code"
        )
)
public class Campaign {
    //id
    @Id //marca la PK
    @SequenceGenerator(
            name="campaign_sequence",
            sequenceName="campaign_sequence",
            allocationSize = 1 //el default suele ser 50
    )
    @GeneratedValue(
            generator = "campaign_sequence",
            strategy = GenerationType.SEQUENCE //genera una secuencia y la aumenta de uno en uno para el id
    )

    private Long campaignId;
    //code
    @Column(
            name = "campaign_code",
            nullable = false
    )
    private String campaignCode;
    //startdate
    private Date startDate;
    //enddate
    private Date endDate;
    //description
    private String description;

    @Embedded //con esto incrusto storehouse en Campaign
    private Storehouse storehouse;

    @OneToOne //para mostrar relacion uno a uno
    @JoinColumn( //se debe usar una FK para relacionar con la PK  de Director
            name="director_id",
            referencedColumnName = "directorId"
    )
    private Director director;
}
