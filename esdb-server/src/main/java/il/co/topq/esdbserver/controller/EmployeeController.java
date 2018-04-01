package il.co.topq.esdbserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import il.co.topq.esdbserver.exception.ResourceNotFoundException;
import il.co.topq.esdbserver.model.Employee;
import il.co.topq.esdbserver.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEnployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @GetMapping("/employees/{id}")
    public Employee getNoteById(@PathVariable(value = "id") Long employeeId) {
        return employeeRepository
        		.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @PutMapping("/employees/{id}")
    public Employee updateNote(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody Employee employeeDetails) {

    	Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

    	employee.update(employeeDetails);
    	
        employee = employeeRepository.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long employeeId) {
    	Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

    	employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }
}
