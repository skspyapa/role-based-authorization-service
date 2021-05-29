package lk.sky360solutions.authorization.role.service.impl;

import lk.sky360solutions.authorization.role.model.Product;
import lk.sky360solutions.authorization.role.repository.ProductRepository;
import lk.sky360solutions.authorization.role.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> listAll() {
    return productRepository.findAll();
  }

  @Override
  public void save(Product product) {
    productRepository.save(product);
  }

  @Override
  public Product get(Long id) {
    return productRepository.findById(id).get();
  }

  @Override
  public void delete(Long id) {
    productRepository.deleteById(id);
  }
}
