package net.fullstacksprinboot.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.fullstacksprinboot.ems_backend.dto.EmployeeDto;
import net.fullstacksprinboot.ems_backend.entity.Employee;
import net.fullstacksprinboot.ems_backend.exception.ResourceNotFoundException;
import net.fullstacksprinboot.ems_backend.mapper.EmployeeMapper;
import net.fullstacksprinboot.ems_backend.repository.EmployeeRepository;
import net.fullstacksprinboot.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with a given Id:" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }


}
