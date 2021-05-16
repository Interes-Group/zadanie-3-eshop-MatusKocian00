package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private double price;

    @OneToMany
    private List<ShoppingItem> shoppingList = new ArrayList<>();



}
