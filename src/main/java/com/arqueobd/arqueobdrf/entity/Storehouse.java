package com.arqueobd.arqueobdrf.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable //esta clase será incrustable en otras clases. Revisar @AttributeOverride
public class Storehouse {
    private String storehouseName;
    private String storehouseCity;
    private String storehouseMainStreet;
    private String storehouseCCAA;
}
