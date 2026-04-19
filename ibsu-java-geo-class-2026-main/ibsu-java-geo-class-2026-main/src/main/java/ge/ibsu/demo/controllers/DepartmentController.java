package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.DepartmentInfo;
import ge.ibsu.demo.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController extends BaseController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentInfo>> getDepartments(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city) {

        List<DepartmentInfo> result = departmentService.getDepartments(country, city);
        return ResponseEntity.ok(result);
    }
}