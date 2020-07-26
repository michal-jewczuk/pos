package net.jewczuk.posdomain.repository;

import net.jewczuk.posdomain.config.PosDomainConfig;
import net.jewczuk.posdomain.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = PosDomainConfig.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    @DisplayName("should return products that have given category")
    public void shouldReturnNonEmptyList() {
        String category = "yellow";

        List<Product> products = repository.findAllProductsByCategoryName(category);

        assertThat(products.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("should return empty list for nonexistent category")
    public void shouldReturnEmptyList() {
        String category = "blue";

        List<Product> products = repository.findAllProductsByCategoryName(category);

        assertThat(products).isEmpty();
    }
}
