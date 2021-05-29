package lk.sky360solutions.authorization.role.service;

import lk.sky360solutions.authorization.role.model.Product;

import java.util.List;

public interface ProductService {

  List<Product> listAll();

  void save(Product product);

  Product get(Long id);

  void delete(Long id);
}
