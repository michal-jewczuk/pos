package net.jewczuk.posdomain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BasketItem extends AbstractEntity {

    @OneToOne
    private Product product;

    private int quantity;

}
