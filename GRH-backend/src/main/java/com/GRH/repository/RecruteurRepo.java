package com.GRH.repository;

import com.GRH.model.Recruteur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruteurRepo extends MongoRepository<Recruteur, String> {
}
