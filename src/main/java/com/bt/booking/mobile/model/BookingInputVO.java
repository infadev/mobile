package com.bt.booking.mobile.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookingInputVO {
    @NotNull
    private Long mobileID;
    @NotNull
    private Long employeeId;
}
