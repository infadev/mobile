package com.bt.booking.mobile.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MobileInputVO {
    @NotBlank
    private Long mobileId;
}
