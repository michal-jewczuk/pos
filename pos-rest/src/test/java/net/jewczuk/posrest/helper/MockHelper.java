package net.jewczuk.posrest.helper;

import net.jewczuk.posrest.dto.CategoryDto;
import net.jewczuk.posrest.dto.ProductDto;

import java.util.Arrays;
import java.util.List;

public enum MockHelper {

    INSTANCE;

    public List<ProductDto> getMockedProducts() {
        List<CategoryDto> categories = getMockedCategories();

        ProductDto p1 = ProductDto.builder()
                .id(1L)
                .name("Product 1")
                .price(1000)
                .category(categories.get(0))
                .build();
        ProductDto p2 = ProductDto.builder()
                .id(2L)
                .name("Product 2")
                .price(2500)
                .category(categories.get(1))
                .build();
        ProductDto p3 = ProductDto.builder()
                .id(3L)
                .name("Product 3")
                .price(12300)
                .category(categories.get(0))
                .build();

        return Arrays.asList(p1, p2, p3);
    }

    public List<CategoryDto> getMockedCategories() {
        CategoryDto c1 = new CategoryDto(11L, "red");
        CategoryDto c2 = new CategoryDto(12L, "white");

        return Arrays.asList(c1, c2);
    }
}
