package sk.stuba.fei.uim.oop.assignment3.ShoppingItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long amount;

    private Double price;

    @ManyToOne
    private Product product;


    public ShoppingItem(Product product, Long amount) {
        this.amount = amount;
        this.product = product;
        this.price = product.getPrice();
    }

}
