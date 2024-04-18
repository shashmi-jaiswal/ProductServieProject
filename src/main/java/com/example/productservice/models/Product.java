package com.example.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
//    @Id
//    private long id;
    private String title;
    @ManyToOne(cascade = {CascadeType.PERSIST})

    private Category category;
    private double price;
    private String description;
    private String image;

}

/*
        1    -->     1

      Product ----- Category   ===> m:1
       M     <---    1
       ---------------------
       M ---         1
 */

