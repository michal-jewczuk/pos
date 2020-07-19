package net.jewczuk.posdomain.repository;

import net.jewczuk.posdomain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
