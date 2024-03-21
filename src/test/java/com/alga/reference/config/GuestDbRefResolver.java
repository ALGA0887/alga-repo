package com.alga.reference.config;

import com.alga.reference.model.Guest;
import com.alga.reference.model.OrderItem;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DocumentReferenceSource;
import org.springframework.data.mongodb.core.convert.ReferenceLookupDelegate;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;

import java.lang.reflect.Constructor;

public class GuestDbRefResolver extends DefaultDbRefResolver {

    public GuestDbRefResolver(MongoDatabaseFactory mongoDbFactory) {
        super(mongoDbFactory);
    }

    @SneakyThrows
    @Override
    public Object resolveReference(MongoPersistentProperty property, Object source, ReferenceLookupDelegate referenceLookupDelegate, MongoEntityReader entityReader) {
        Object resultSource = source;
        if (source instanceof DocumentReferenceSource drs && drs.getTargetSource() != null && "orderItems".equals(property.getFieldName())) {
            Class<?> ownerClass = property.getOwner().getTypeInformation().getType();
            Class<?> targetClass = property.getAssociationTargetType();
            if (ownerClass == Guest.class && targetClass == OrderItem.class) {
                // Why constructor for DocumentReferenceSource is not public?
                Constructor<DocumentReferenceSource> drsc = DocumentReferenceSource.class.getDeclaredConstructor(Object.class, Object.class);
                drsc.setAccessible(true);
                resultSource = drsc.newInstance(drs.getSelf(), null);
            }
        }
        return super.resolveReference(property, resultSource, referenceLookupDelegate, entityReader);
    }

}
