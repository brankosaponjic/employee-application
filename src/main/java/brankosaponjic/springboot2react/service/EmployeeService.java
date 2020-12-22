package brankosaponjic.springboot2react.service;

import brankosaponjic.springboot2react.model.Employee;
import brankosaponjic.springboot2react.repository.EmployeeDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    public ResponseEntity<Employee> findById(Long id) {
        return employeeDAO.findById(id);
    }

    public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {
        return employeeDAO.updateEmployee(id, employee);
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
        return employeeDAO.deleteEmployee(id);
    }
}
