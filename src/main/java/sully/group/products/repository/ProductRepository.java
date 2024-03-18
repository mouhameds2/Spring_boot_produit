package sully.group.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sully.group.products.entity.Avis;
import sully.group.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
   Iterable <Product> findByName(String name);
    Iterable <Product> findByPriceAfter(int price);
    Iterable <Product> findByAvisTextContaining(String text);
}
