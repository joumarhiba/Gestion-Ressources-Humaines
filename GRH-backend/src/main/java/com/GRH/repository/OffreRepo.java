package com.GRH.repository;

import com.GRH.model.Offre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OffreRepo extends MongoRepository<Offre, String> {
}
