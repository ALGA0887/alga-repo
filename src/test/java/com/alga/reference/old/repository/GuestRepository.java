package com.alga.reference.old.repository;

import com.alga.reference.old.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "OldGuestRepository")
public interface GuestRepository extends MongoRepository<Guest, String> {
}
