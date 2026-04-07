package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.AddEmployee;
import ge.ibsu.demo.entities.Department;
import ge.ibsu.demo.entities.Employee;
import ge.ibsu.demo.repositories.EmployeeRepository;
import ge.ibsu.demo.utils.GeneralUtil;
import jakarta.persistence.Id;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepository employeeRepository , DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService=departmentService;
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Employee getById(Long id) throws Exception {
        return this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EMPLOYEE_NOT_FOUND"));
    }

    public  Employee save(AddEmployee data,Long id) throws  Exception{
        Employee employee = new Employee();
        GeneralUtil.checkRequiredProperties(data, Arrays.asList("firstname", "lastName", "phone", "email", "salary"));

        if(id!=null)
            employee=getById(id);

//        employee.setFirstName(data.getFirstName());
//        employee.setLastName(data.getLastName());
//        employee.setPhone(data.getPhone());
//        employee.setEmail(data.getPhone());
//        employee.setSalary(data.getSalary());
        GeneralUtil.getCopyOf(data, employee);
        employee.setHireDate(new Date());



        Department department = departmentService.getById(data.getDepartmendId());

        employee.setDepartment((department));

        return employeeRepository.save(employee);

    }
}
