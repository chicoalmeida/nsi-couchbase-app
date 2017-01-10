package io.chico.pocs.couchbase.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@Document
public class Product {

    /**
     * This will generate the key of the document
     * */
    @Id
    @Field
    private String id;


    /**
     * The other fields bellow will be refereed by the key above
     * */
    @Field
    @NotNull
    private String name;

    @Field
    @NotNull
    private String brand;

    @Field
    @NotNull
    private Date created;

}