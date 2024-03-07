package com.bt.booking.mobile.controller;

import com.bt.booking.mobile.entity.Mobile;
import com.bt.booking.mobile.exception.MobileBookingException;
import com.bt.booking.mobile.facade.MobileFacade;
import com.bt.booking.mobile.model.MobileInputVO;
import com.bt.booking.mobile.model.SuccessResponse;
import com.bt.booking.mobile.util.ApplicationConstants;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = ApplicationConstants.DEFAULT_MAPPING,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MobileController {

    @Autowired
    MobileFacade mobileFacade;

    @Operation(summary = "Get all Mobile Information")
    @GetMapping("/mobiles")
    @ResponseBody
    public ResponseEntity<Object> getAllEmployeeDetails() {
        List<Mobile> employees = mobileFacade.findall();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Add new Mobile")
    @PostMapping("/mobile/new")
    @ResponseBody
    public SuccessResponse addEmployeeDetails(@Valid @RequestBody Mobile mobilePayload) {
        Optional<Mobile> mobile = mobileFacade.findById(mobilePayload.getMobileId());
        if (!mobile.isEmpty()) {
            throw new MobileBookingException("Mobile already exists");
        }
        mobileFacade.save(mobilePayload);
        return new SuccessResponse(Integer.valueOf(HttpStatus.OK.value()), "Mobile information added  " + mobilePayload.getMobileId());
    }

    @Operation(summary = "Delete a Mobile")
    @PostMapping("/mobile/delete")
    @ResponseBody
    public SuccessResponse deleteEmployee(@Valid @RequestBody MobileInputVO mobilePayload) {
        Optional<Mobile> employee = mobileFacade.findById(mobilePayload.getMobileId());
        if (employee.isEmpty()) {
            throw new MobileBookingException("Employee doesn't exists!!!");
        }
        mobileFacade.deleteById(mobilePayload.getMobileId());
        return new SuccessResponse(Integer.valueOf(HttpStatus.OK.value()), "Mobile Deleted " + mobilePayload.getMobileId());
    }

}
