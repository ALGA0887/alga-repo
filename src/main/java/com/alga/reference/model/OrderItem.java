package com.alga.reference.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "order-items")
public class OrderItem {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private List<String> guestIds;

}
