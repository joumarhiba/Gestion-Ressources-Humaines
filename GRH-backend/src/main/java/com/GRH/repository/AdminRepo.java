package com.GRH.repository;

import com.GRH.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository<Admin, String> {
}
