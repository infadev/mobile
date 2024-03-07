package com.bt.booking.mobile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Mobile {
    @Id
    private Long mobileId;
    @NotBlank
    private String mobileName;
    private Integer availableUnits;
}
