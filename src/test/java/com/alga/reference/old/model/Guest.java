package com.alga.reference.old.model;

import com.alga.reference.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "guests")
public class Guest {

    @Id
    private String id;
    @Field
    private String name;
    @DBRef
    private List<OrderItem> orderItems;

}
