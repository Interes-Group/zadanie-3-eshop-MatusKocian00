package sk.stuba.fei.uim.oop.assignment3.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.ShoppingItem.ShoppingItemRequest;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CartResponse create(){
        return new CartResponse(this.cartService.createCart());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.cartService.deleteCart(id);
    }

    @GetMapping("/{id}")
    public CartResponse findById(@PathVariable("id") Long id){
        return new CartResponse(this.cartService.getCart(id));
    }

    @PostMapping("/{id}/add")
    public CartResponse addItem(@PathVariable("id") Long id, @RequestBody ShoppingItemRequest request){
        return new CartResponse(this.cartService.addProductToCart(id,request));
    }

    @GetMapping("/{id}/pay")
    public String getPayed(@PathVariable("id") Long id){
        return Double.toString(this.cartService.getPayed(id));
    }

}
