package net.fullstacksprinboot.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.fullstacksprinboot.ems_backend.dto.EmployeeDto;
import net.fullstacksprinboot.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Step 1: Build ADD Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Step 2: Build GET Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
         EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
         return  ResponseEntity.ok(employeeDto);
    }

}
