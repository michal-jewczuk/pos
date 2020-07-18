package net.jewczuk.posdomain.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends AbstractEntity {

    private String name;
    private Integer price;
    private String description;
    private String image;

}
