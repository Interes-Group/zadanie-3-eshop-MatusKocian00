package sk.stuba.fei.uim.oop.assignment3.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping
    public List<ProductResponse>getAllProducts(){
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ProductResponse addProduct(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.createProduct(request));
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id){
        return this.service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.service.delete(id);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@RequestBody ProductRequest request, @PathVariable("id") Long id){
        return new ProductResponse(this.service.updateProduct(request,id));
    }

    @GetMapping("/{id}/amount")
    public Map<String, Integer> getAmount(@PathVariable("id") Long id) {
        return Collections.singletonMap("amount", this.service.getAmount(id)
        );
    }
    @PostMapping("/{id}/amount")
    public Map<String, Integer> getAmount(@PathVariable("id") Long id, @RequestBody ProductRequest request) {
        return Collections.singletonMap("amount", this.service.updateAmount(request, id));
    }
}
