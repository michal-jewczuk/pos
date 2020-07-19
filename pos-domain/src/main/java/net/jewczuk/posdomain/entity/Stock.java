package net.jewczuk.posdomain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Stock extends AbstractEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockItem> stocks;

}
