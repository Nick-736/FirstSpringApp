package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.DepartmentInfo;
import ge.ibsu.demo.entities.Department;
import ge.ibsu.demo.repositories.DepartmentRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public Department getById(Long id) throws ResourceNotFoundException {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DEPARTMENT_NOT_FOUND"));
    }

    public List<DepartmentInfo> getDepartments(String country, String city) {
        return departmentRepository.findDepartmentInfoFiltered(country, city);
    }
}