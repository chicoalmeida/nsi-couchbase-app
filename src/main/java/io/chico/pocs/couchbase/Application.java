package io.chico.pocs.couchbase;


import io.chico.pocs.couchbase.domain.Product;
import io.chico.pocs.couchbase.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableCouchbaseRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner createSampleProduct(ProductRepository productRepository) {
        return args -> {
            List<Product> toSave = new ArrayList<>();


            for (int i = 0; i < 100000; i++) {
                toSave.add(Product.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Black Tulip")
                        .brand("NEST")
                        .created(new Date())
                        .build());
            }
            productRepository.save(toSave).forEach(product -> System.out.println());


        };
    }
}
