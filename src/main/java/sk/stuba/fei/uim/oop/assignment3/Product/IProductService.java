package sk.stuba.fei.uim.oop.assignment3.Product;


import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product findById(Long id);
    void delete(Long id);
    Product createProduct(ProductRequest request);
    Product updateProduct(ProductRequest request, Long id);
    Long getAmount(Long id);
    Long updateAmount(ProductRequest request, Long id);
    Product save(Product p);
}
