package net.jewczuk.posrest.controller;

import lombok.RequiredArgsConstructor;
import net.jewczuk.posrest.dto.ProductDto;
import net.jewczuk.posrest.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/")
    public RedirectView redirectToList() {
        return new RedirectView("/api/products");
    }

    @GetMapping("/{id}")
    public ProductDto getSingleProduct(@PathVariable String id) {
        Long productId = Long.parseLong(id);

        return productService.getProductById(productId);
    }
}
