package com.GRH.repository;

import com.GRH.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepo extends MongoRepository<Application, String> {
}
