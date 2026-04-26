package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.DepartmentInfo;
import ge.ibsu.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    @Query("""
        SELECT new ge.ibsu.demo.dto.DepartmentInfo(
            d.departmentName,
            CONCAT(e.firstName, ' ', e.lastName),
            c.countryName,
            l.city,
            l.streetAddress
        )
        FROM Department d
        LEFT JOIN d.manager e
        LEFT JOIN d.location l
        LEFT JOIN l.country c
        WHERE (:country IS NULL OR LOWER(c.countryName) = LOWER(:country))
          AND (:city    IS NULL OR LOWER(l.city)        = LOWER(:city))
    """)
    List<DepartmentInfo> findDepartmentInfoFiltered(
            @Param("country") String country,
            @Param("city")    String city
    );
}