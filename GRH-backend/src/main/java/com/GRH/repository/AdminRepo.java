package com.GRH.repository;

import com.GRH.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

// TODO : add relations in models references
public interface AdminRepo extends MongoRepository<Admin, String> {
}
