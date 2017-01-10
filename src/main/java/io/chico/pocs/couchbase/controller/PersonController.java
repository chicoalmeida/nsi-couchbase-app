package io.chico.pocs.couchbase.controller;

import io.chico.pocs.couchbase.domain.Product;
import io.chico.pocs.couchbase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chico on 08/01/17.
 */
@RestController
public class PersonController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productRepository.findAll();
    }


}
