package brankosaponjic.springboot2react.repository;

import brankosaponjic.springboot2react.ecxeption.ResourceNotFoundException;
import brankosaponjic.springboot2react.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDAO {

    private final EmployeeRepository employeeRepository;

    public EmployeeDAO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) { return employeeRepository.save(employee); }

    public ResponseEntity<Employee> findById(Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id: " + id));
        return ResponseEntity.ok(emp);
    }

    public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id: " + id));
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        emp.setImage(employee.getImage());
        emp.setDayOfBirth(employee.getDayOfBirth());
        emp.setEntryDate(employee.getEntryDate());
        Employee updatedEmployee = employeeRepository.save(emp);
        return ResponseEntity.ok(updatedEmployee);
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id: " + id));
        employeeRepository.delete(emp);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted employee: " + emp.getFirstName() + " " + emp.getLastName(), Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
