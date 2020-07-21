package net.jewczuk.posrest.controller;

import lombok.RequiredArgsConstructor;
import net.jewczuk.posrest.dto.ProductDto;
import net.jewczuk.posrest.exception.BadRequestException;
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
        // id is a String so that we can throw our own exception
        // when user enters not a number
        Long productId;

        try {
            productId = Long.parseLong(id);
        } catch (Exception ex) {
            throw new BadRequestException();
        }

        return productService.getProductById(productId);
    }
}
