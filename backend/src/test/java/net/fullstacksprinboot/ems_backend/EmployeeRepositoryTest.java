package net.fullstacksprinboot.ems_backend;

import net.fullstacksprinboot.ems_backend.entity.Employee;
import net.fullstacksprinboot.ems_backend.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// add this to remove error related to @DatajpaTest annotation
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    //JUnit Test for Save Employee
    @Test
    public void saveEmployeeTest(){
        //create employee object
        Employee employee = Employee.builder()
                .firstName("Daniel")
                .lastName("Brookes")
                .email("danielbrk@yahoo.com")
                .build();
        employeeRepository.save(employee);
        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    //JUnit Test for Get Employee
    @Test
    public void getEmployeeTest(){
        Employee employee = employeeRepository.findById(1L).get();
        Assertions.assertThat(employee.getId()).isEqualTo(1L);
    }

    //JUnit Test for Get  All Employees
    @Test
    public void getListOfEmployeesTest(){

        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }

    //JUnit Test for Update Employee
    @Test
    public void updateEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        employee.setFirstName("William");
        employee.setLastName("Ford");
        employee.setEmail("williamform@gmail.com");

        Employee employeeUpdated =  employeeRepository.save(employee);

        Assertions.assertThat(employeeUpdated.getFirstName()).isEqualTo("William");
        Assertions.assertThat(employeeUpdated.getLastName()).isEqualTo("Ford");
        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("williamform@gmail.com");

    }

    //JUnit Test for Delete Employee
    @Test
    public void deleteEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        //employeeRepository.deleteById(1L);  <- can also use this for deleteById Method
        employeeRepository.delete(employee);
        Employee employee1 = null;
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("williamform@gmail.com");

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();
    }


}
