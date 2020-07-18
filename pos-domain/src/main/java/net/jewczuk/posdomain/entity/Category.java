package net.jewczuk.posdomain.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends AbstractEntity {

    private String name;

}
