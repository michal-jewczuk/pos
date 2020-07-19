package net.jewczuk.posrest.mapper;

import net.jewczuk.posdomain.entity.Product;
import net.jewczuk.posrest.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto mapToProductDto(Product product);
}
