package net.fullstacksprinboot.ems_backend.repository;

import net.fullstacksprinboot.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
