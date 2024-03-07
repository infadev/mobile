package com.bt.booking.mobile.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Status of Success Response")
public class SuccessResponse {
    private Integer status;
    private String response;
}
