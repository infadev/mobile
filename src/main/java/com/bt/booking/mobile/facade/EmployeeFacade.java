package com.bt.booking.mobile.facade;

import com.bt.booking.mobile.entity.Employee;
import com.bt.booking.mobile.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class EmployeeFacade {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findall() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
