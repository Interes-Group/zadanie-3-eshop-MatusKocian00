package sk.stuba.fei.uim.oop.assignment3.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.Exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
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

        Product p2 = new Product();
        p2.setName("Oranges");
        p2.setAmount(20L);
        p2.setPrice(20.0);
        p2.setUnit("g");
        p2.setDescription("Old");
        this.repository.save(p2);

    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return this.repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found"));
    }

    public Product createProduct(ProductRequest request){
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setPrice(request.getPrice());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        return this.repository.save(newProduct);
    }

    @Override
    public Product updateProduct(ProductRequest request, Long id) {
        Product updatedProduct = this.repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found"));
        if (request.getDescription()!= null){
            updatedProduct.setDescription(request.getDescription());
        }

        if (request.getName()!= null){
            updatedProduct.setName(request.getName());
        }
        return this.repository.save(updatedProduct);
    }

    @Override
    public Long getAmount(Long id) {
        Product p = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The product was not found"));
        return p.getAmount();
    }

    @Override
    public Long updateAmount(ProductRequest request, Long id) {
        Product p = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The product was not found"));
        p.setAmount(p.getAmount() + request.getAmount());
        this.repository.save(p);
        return p.getAmount();
    }

    @Override
    public Product findById(Long id) {
        return this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The product was not found"));
    }

    @Override
    public void delete(Long id){
        Product p = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The product was not found"));
        this.repository.delete(p);
    }

    @Override
    public Product save(Product p){
        return this.repository.save(p);
    }


}
