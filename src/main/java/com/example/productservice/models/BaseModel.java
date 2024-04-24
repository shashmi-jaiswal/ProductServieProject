package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new  Date();
    }
}

/*
@Temporal(TemporalType.TIMESTAMP) is used to indicate that the createdAt field should
be mapped to a database timestamp.
@PrePersist annotation is used to specify a method to be called before the entity is persisted.
In this case, onCreate() method sets the createdAt field to the current date and time.
Now, when you persist an instance of YourEntity, the createdAt field will automatically
 be set to the current date and time.
 */