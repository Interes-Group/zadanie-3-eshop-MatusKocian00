package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;
import sk.stuba.fei.uim.oop.assignment3.Product.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItem;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItemRequest;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItemResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private Long id;
    private List<ShoppingItemResponse> shoppingList;
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList().stream().map(ShoppingItemResponse::new).collect(Collectors.toList());
        this.payed = cart.getPayed();

    }
}


