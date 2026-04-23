package ge.ibsu.quiz.repositories;

import ge.ibsu.quiz.dto.ProductStats;
import ge.ibsu.quiz.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("""
        SELECT new ge.ibsu.quiz.dto.ProductStats(
            p.category,
            AVG(p.price)
        )
        FROM Product p
        GROUP BY p.category
    """)
    List<ProductStats> findAveragePriceByCategory();
}
