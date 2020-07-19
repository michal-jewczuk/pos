package net.jewczuk.posrest.mapper;

import net.jewczuk.posdomain.entity.Category;
import net.jewczuk.posrest.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto mapToCategoryDto(Category category);
}
