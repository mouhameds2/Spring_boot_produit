package sully.group.products;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sully.group.products.services.ProductService;

@AllArgsConstructor
@SpringBootApplication
public class ProductsApplication implements CommandLineRunner {


	private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	this.productService.genereProduit();
	}
}
