package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.EmployeePhoneInfo;
import ge.ibsu.demo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.department.id = :depId")
    List<Employee> getByDepartment(@Param("depId") Long departmentId);

    @Query(value="select e from Employee e where e.department.id = :depId",
    nativeQuery = true)
    List<Employee> getByDepartmentNativeQuery(@Param("depId") Long departmentId);

    @Query("select e from Employee e" +
    "where (:searchText is null or concat(e.firstName, concat(' ', e.lastName)) like :searchText)")
    Page<Employee> search(@Param("searchText") String searchText, Pageable pageable);

    @Query(value = "select * from Employee e" +
            "where (:searchText is null or concat(e.firstName, concat(' ', e.lastName)) like :searchText)",
    countQuery = "select count(*) from employees" +
            "(:searchText is null or concat(e.firstName, concat(' ', e.lastName)) like :searchText)",
    nativeQuery = true)
    Page<Employee> searchViaNative(@Param("searchText") String searchText, Pageable pageable);

    List<EmployeePhoneInfo> findAllByPhoneLike(String phone);
    <T> T findByPhoneOrEmail(String phone, String email, Class<T> type);
}
