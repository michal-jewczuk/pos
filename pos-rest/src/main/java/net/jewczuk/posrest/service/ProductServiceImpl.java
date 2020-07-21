package net.jewczuk.posrest.service;

import lombok.RequiredArgsConstructor;
import net.jewczuk.posdomain.entity.Product;
import net.jewczuk.posdomain.repository.ProductRepository;
import net.jewczuk.posrest.dto.ProductDto;
import net.jewczuk.posrest.exception.ExceptionMessages;
import net.jewczuk.posrest.exception.ResourceNotFoundException;
import net.jewczuk.posrest.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapperProduct;

    @Override
    @Transactional
    public List<ProductDto> getAllProducts() {
        return repository.findAll().stream()
                .map(p -> mapperProduct.mapToProductDto(p))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDto getProductById(Long id) {
        Optional<Product> optional = repository.findById(id);

        return mapperProduct.mapToProductDto(optional.orElseThrow(ResourceNotFoundException::new));
    }
}
