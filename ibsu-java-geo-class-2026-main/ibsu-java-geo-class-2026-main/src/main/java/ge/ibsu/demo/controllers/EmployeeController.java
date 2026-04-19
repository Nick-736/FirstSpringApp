package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.*;
import ge.ibsu.demo.entities.Employee;
import ge.ibsu.demo.services.DepartmentService;
import ge.ibsu.demo.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
   // private  final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) throws Exception {
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    public Employee add(@RequestBody AddEmployee addEmployee) throws Exception {
        return employeeService.saveEmployee(addEmployee,null);
    }

    @PutMapping("/{id}")
    public Employee edit(@PathVariable Long id, @RequestBody AddEmployee addEmployee) throws  Exception{
        return  employeeService.saveEmployee(addEmployee, id);
    }
//    @GetMapping("/{id}/employees")
//    public  List<Employee> getEmployees(@PathVariable Long id ){
//        return employeeService.getByDepartment(id);
//    }

    @PostMapping("/search")
    public Page<Employee> search(@RequestBody RequestData<SearchEmployee> rd){
        return employeeService.search(rd.getData(), rd.getPaging());
    }
//    @PostMapping("/searchByPhone")
//    public List<EmployeePhoneInfo> searchByPhone(@RequestBody RequestData<SearchEmployee> rd){
//        return employeeService.getByPhone(rd.getData());
//    }
@PostMapping("/searchContactInfo")
public EmployeeContactInfo searchContactInfo(@RequestBody RequestData<SearchEmployee> rd) {
    return employeeService.getEmployeeContacts(rd.getData());
}
}
