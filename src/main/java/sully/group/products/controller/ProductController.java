package sully.group.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sully.group.products.entity.Product;
import sully.group.products.services.ProductService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "product",produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private ProductService productService;
    @GetMapping
    public Iterable<Product> search(@RequestParam(required = false) String name){
        return  this.productService.search(name);
    }

    @GetMapping(path="prix")
    public Iterable<Product> price(@RequestParam(required = false) int price){
        return this.productService.price(price);
    }

    @GetMapping(path="text")
    public Iterable<Product> text(@RequestParam(required = false) String text){
        return this.productService.text(text);
    }


    /*
    @GetMapping(path = "name")
    public Iterable <Product> nameProduct(@RequestParam String name){
        return  this.productService.nameProduct(name);
    }
    **/


}
