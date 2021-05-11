package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;

        Product p1 = new Product();
        p1.setName("Jahoda");
        p1.setAmount(10L);
        p1.setPrice(20.0);
        p1.setUnit("g");
        p1.setDescription("Fresh");
        this.repository.save(p1);

    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    public Product create(ProductRequest request){
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setPrice(request.getPrice());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        return this.repository.save(newProduct);
    }
}
