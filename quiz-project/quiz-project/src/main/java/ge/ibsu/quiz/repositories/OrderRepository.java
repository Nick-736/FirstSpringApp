package ge.ibsu.quiz.repositories;

import ge.ibsu.quiz.entities.Order;
import ge.ibsu.quiz.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("""
        SELECT o FROM Order o
        WHERE LOWER(o.customerName) LIKE LOWER(CONCAT('%', :customerName, '%'))
          AND o.status = :status
        ORDER BY o.createdAt DESC
    """)
    List<Order> searchByCustomerNameAndStatus(
        @Param("customerName") String customerName,
        @Param("status") OrderStatus status
    );
}
