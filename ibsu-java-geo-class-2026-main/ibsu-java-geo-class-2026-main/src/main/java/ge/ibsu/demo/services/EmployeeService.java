package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.Employee;
import ge.ibsu.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Employee getById(Long id) throws Exception {
        return this.employeeRepository.findById(id).orElseThrow(() -> new Exception("EMPLOYEE_NOT_FOUND"));
    }
}
