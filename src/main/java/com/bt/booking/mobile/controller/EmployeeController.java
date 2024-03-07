package com.bt.booking.mobile.controller;

import com.bt.booking.mobile.entity.Employee;
import com.bt.booking.mobile.exception.MobileBookingException;
import com.bt.booking.mobile.facade.EmployeeFacade;
import com.bt.booking.mobile.model.EmployeeInputVO;
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
public class EmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @Operation(summary = "Get all Employee Details")
    @GetMapping("/employees")
    @ResponseBody
    public ResponseEntity<Object> getAllEmployeeDetails() {
        List<Employee> employees = employeeFacade.findall();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Add new Employee")
    @PostMapping("/employees/new")
    @ResponseBody
    public SuccessResponse addEmployeeDetails(@Valid @RequestBody Employee employeePayload) {
        Optional<Employee> employee = employeeFacade.findById(employeePayload.getId());
        if (!employee.isEmpty()) {
            throw new MobileBookingException("Employee already exists");
        }
        employeeFacade.save(employeePayload);
        return new SuccessResponse(Integer.valueOf(HttpStatus.OK.value()), "Employee added  " + employeePayload.getName());
    }

    @Operation(summary = "Delete Employee")
    @PostMapping("/employees/delete")
    @ResponseBody
    public SuccessResponse deleteEmployee(@Valid @RequestBody EmployeeInputVO employeePayload) {
        Optional<Employee> employee = employeeFacade.findById(employeePayload.getEmployeeId());
        if (employee.isEmpty()) {
            throw new MobileBookingException("Employee doesn't exists!!!");
        }
        employeeFacade.deleteById(employeePayload.getEmployeeId());
        return new SuccessResponse(Integer.valueOf(HttpStatus.OK.value()), "Employee Deleted " + employeePayload.getEmployeeId());
    }
}
