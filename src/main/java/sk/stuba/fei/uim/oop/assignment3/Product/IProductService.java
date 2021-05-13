package sk.stuba.fei.uim.oop.assignment3.Product;


import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product findById(Long id);
    void delete(Long id);
    Product createProduct(ProductRequest request);
    Product updateProduct(ProductRequest request, Long id);
    int getAmount(Long id);
    int updateAmount(ProductRequest request, Long id);
}
