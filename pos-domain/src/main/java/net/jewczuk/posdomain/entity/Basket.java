package net.jewczuk.posdomain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket extends AbstractEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketItem> items;

    private Long date;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
