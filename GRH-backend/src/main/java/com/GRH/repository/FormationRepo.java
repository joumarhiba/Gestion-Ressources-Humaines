package com.GRH.repository;

import com.GRH.model.Formation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepo extends MongoRepository<Formation, String> {
}
