package sk.stuba.fei.uim.oop.assignment3.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.stuba.fei.uim.oop.assignment3.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.Product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

import sk.stuba.fei.uim.oop.assignment3.ResourceNotFoundException;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShopItemsRepository;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItem;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItemRequest;



@Service
public class CartService implements ICartService {



    private CartRepository cartRepository;

    @Autowired
    private IProductService productService;

    @Autowired
    private ShopItemsRepository shopItemsRepository;



    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
        Cart c1 = new Cart();
        c1.setPayed(false);
        Cart c2 = new Cart();
        c2.setPayed(false);
        this.cartRepository.save(c1);
        this.cartRepository.save(c2);
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        cart.setPayed(false);
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart addProductToCart(Long cartId, ShoppingItemRequest request) {
        Cart cart = this.cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("The cart was not found"));
        if(cart.getPayed()) throw new BadRequestException("Already paid, cannot add");
        Product product = this.productService.getById(request.getProductId());
        ShoppingItem item = new ShoppingItem(product,request.getAmount());
        if (product.getAmount() >= request.getAmount()) {
            product.setAmount(product.getAmount() - request.getAmount());
            item.setAmount(request.getAmount());
            if (cart.getShoppingList().contains(item)){
                System.out.println("Hello");
            }
            else{

                cart.getShoppingList().add(item);
            }
        }
        else throw new BadRequestException("Not enough products");

        this.shopItemsRepository.save(item);
        this.productService.save(product);
        return this.cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        Cart c = this.cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The cart was not found"));
        this.cartRepository.delete(c);
    }

    @Override
    public Cart getCart(Long id) {
        return this.cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The cart was not found"));
    }

    @Override
    public Cart save(Cart c) {
        return this.cartRepository.save(c);
    }

    @Override
    public Double getPayed(Long id) {
        Double total = 0.0;
        Cart c = this.cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The cart was not found"));
        if (c.getPayed()) throw new BadRequestException("Already paid");
        else {
            for (ShoppingItem item : c.getShoppingList()) {
                total += (item.getPrice() * item.getAmount());
            }
            c.setPayed(true);
            this.cartRepository.save(c);
            return total;
        }
    }
}