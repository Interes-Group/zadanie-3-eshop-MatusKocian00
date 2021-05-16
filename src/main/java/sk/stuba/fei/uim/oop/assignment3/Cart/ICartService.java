package sk.stuba.fei.uim.oop.assignment3.Cart;

import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItemRequest;

public interface ICartService {
    Cart createCart();
    Cart addProductToCart(Long CartId, ShoppingItemRequest request);
    void deleteCart(Long id);
    Cart getCart(Long id);
    Cart save(Cart c);
    Double getPayed(Long id);

}
