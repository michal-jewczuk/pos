package net.jewczuk.posrest.service;

import net.jewczuk.posrest.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();
}
