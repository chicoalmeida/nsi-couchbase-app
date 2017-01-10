package io.chico.pocs.couchbase.repository;

import io.chico.pocs.couchbase.domain.Product;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;

/**
 * Created by chico on 08/01/17.
 */
@ViewIndexed(designDoc = "product", viewName = "all")
@N1qlPrimaryIndexed
public interface ProductRepository extends CouchbaseRepository<Product, String> {
    String PREFIX = "product";

    Product findOneByName(String name);
    List<Product> findAll();
    List<Product> findByBrandIs(String brand);
}
