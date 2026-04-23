package ge.ibsu.quiz.controllers;

import ge.ibsu.quiz.dto.EmployeeSummary;
import ge.ibsu.quiz.dto.ProductStats;
import ge.ibsu.quiz.entities.*;
import ge.ibsu.quiz.enums.OrderStatus;
import ge.ibsu.quiz.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class QuizController {

    private final ProductRepository productRepository;
    private final AuthorRepository authorRepository;
    private final OrderRepository orderRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QuizController(ProductRepository productRepository,
                          AuthorRepository authorRepository,
                          OrderRepository orderRepository,
                          DepartmentRepository departmentRepository,
                          EmployeeRepository employeeRepository) {
        this.productRepository = productRepository;
        this.authorRepository = authorRepository;
        this.orderRepository = orderRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/task1/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/task2/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/task3/orders")
    public ResponseEntity<List<Order>> searchOrders(
            @RequestParam String customerName,
            @RequestParam OrderStatus status) {
        return ResponseEntity.ok(
                orderRepository.searchByCustomerNameAndStatus(customerName, status)
        );
    }

    @GetMapping("/task4/departments")
    public ResponseEntity<List<Department>> getDepartmentsWithEmployees() {
        return ResponseEntity.ok(departmentRepository.findAllWithEmployees());
    }

    @GetMapping("/task5/employees")
    public ResponseEntity<List<EmployeeSummary>> getEmployeeSummaries() {
        return ResponseEntity.ok(employeeRepository.findAllProjectedBy());
    }

    @GetMapping("/task6/product-stats")
    public ResponseEntity<List<ProductStats>> getProductStats() {
        return ResponseEntity.ok(productRepository.findAveragePriceByCategory());
    }
}