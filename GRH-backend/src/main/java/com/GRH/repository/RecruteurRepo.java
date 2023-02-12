package com.GRH.repository;

import com.GRH.model.Recruteur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruteurRepo extends MongoRepository<Recruteur, String> {
}
