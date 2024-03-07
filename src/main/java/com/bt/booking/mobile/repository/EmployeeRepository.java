package com.bt.booking.mobile.repository;

import com.bt.booking.mobile.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
