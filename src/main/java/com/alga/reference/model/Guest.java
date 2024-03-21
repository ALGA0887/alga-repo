package com.alga.reference.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "guests")
public class Guest {

    @Id
    private String id;
    @Field
    private String name;
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'guestIds':?#{#self._id}}")
    private List<OrderItem> orderItems;

    public Guest(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
