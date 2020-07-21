package net.jewczuk.posdomain.repository;

import net.jewczuk.posdomain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllProductsByCategoryName(String name);
}
