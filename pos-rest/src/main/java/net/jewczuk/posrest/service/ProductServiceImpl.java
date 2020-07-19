package net.jewczuk.posrest.service;

import lombok.RequiredArgsConstructor;
import net.jewczuk.posdomain.repository.ProductRepository;
import net.jewczuk.posrest.dto.ProductDto;
import net.jewczuk.posrest.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapperProduct;

    @Override
    public List<ProductDto> getAllProducts() {
        return repository.findAll().stream()
                .map(p -> mapperProduct.mapToProductDto(p))
                .collect(Collectors.toList());
    }

}
