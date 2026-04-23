package ge.ibsu.quiz.repositories;

import ge.ibsu.quiz.dto.EmployeeSummary;
import ge.ibsu.quiz.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<EmployeeSummary> findAllProjectedBy();
}
