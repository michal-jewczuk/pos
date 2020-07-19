package net.jewczuk.posrest.controller;

import lombok.RequiredArgsConstructor;
import net.jewczuk.posdomain.entity.Product;
import net.jewczuk.posrest.dto.ProductDto;
import net.jewczuk.posrest.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
