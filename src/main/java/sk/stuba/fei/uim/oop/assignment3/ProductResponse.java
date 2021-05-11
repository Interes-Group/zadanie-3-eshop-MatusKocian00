package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;

    public ProductResponse(Product p){
        this.id = p.getId();
        this.name = p.getName();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.description = p.getDescription();
        this.price = p.getPrice();
    }
}
