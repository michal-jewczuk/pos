package net.jewczuk.posdomain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Stock extends AbstractEntity {

    private List<StockItem> stocks;

}
