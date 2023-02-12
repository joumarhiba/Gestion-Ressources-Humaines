package com.GRH.repository;

import com.GRH.model.Offre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OffreRepo extends MongoRepository<Offre, String> {
}
