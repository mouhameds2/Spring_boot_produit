package sully.group.products.services;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import sully.group.products.entity.Avis;
import sully.group.products.entity.Product;
import sully.group.products.entity.User;
import sully.group.products.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;
//je vais générer un nombre aléatoire de produit par cette methode
    // crtl+alt+v pour introduire une variable en local

    public Iterable<Product> search(String name){
        if(Strings.isNotEmpty(name)) {
            return this.productRepository.findByName(name);
        }else {
            return this.productRepository.findAll();
        }
    }

    public Iterable<Product> price(int price){
        return this.productRepository.findByPriceAfter(price);
    }
    public Iterable<Product> text(String text ){
        return this.productRepository.findByAvisTextContaining(text);
    }



    /* public Iterable <Product> nameProduct(String name){
        return  this.productRepository.findByName(name);
    }**/
    public void genereProduit(){
        Faker faker = new Faker();
        List<Product> produit = IntStream.range(30, 100).mapToObj(index -> {
                    User user = User.builder().name(faker.name().fullName()).build();

            List<Avis> avis = IntStream.range(1, 7).mapToObj(i -> Avis.builder().user(user).text(faker.lorem()
                    .sentence()).build()).collect(Collectors.toList());

            return Product.builder().avis(avis)
                    .name("Product" + index)
                            .price(index * 10).build();

                }
        ).collect(Collectors.toList());

this.productRepository.saveAll(produit);
        

    }



}
