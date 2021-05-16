package sk.stuba.fei.uim.oop.assignment3.ShoppingItem;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShoppingItemResponse {
    private Long productId;
    private Long amount;

    public ShoppingItemResponse(ShoppingItem item) {
        this.productId = item.getProduct().getId();
        this.amount = item.getAmount();
    }
}
