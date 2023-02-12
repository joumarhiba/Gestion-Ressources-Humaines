package com.GRH.repository;

import com.GRH.model.Formation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormationRepo extends MongoRepository<Formation, String> {
}
