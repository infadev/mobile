package com.bt.booking.mobile.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data required to add a new employee")
public class Employee {

    @Id
    private Long id;
    @NotBlank
    private String name;
    private String teamName;
    private String managerName;
}
