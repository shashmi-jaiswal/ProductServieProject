package com.example.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
