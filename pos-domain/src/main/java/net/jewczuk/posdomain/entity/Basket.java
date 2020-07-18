package net.jewczuk.posdomain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket extends AbstractEntity {

    private List<BasketItem> items;
    private Long date;
    private OrderStatus status;

}
