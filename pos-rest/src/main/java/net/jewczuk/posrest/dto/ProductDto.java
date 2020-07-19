package net.jewczuk.posrest.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String image;
    private CategoryDto category;

}
