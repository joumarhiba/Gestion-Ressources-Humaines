package com.GRH.repository;

import com.GRH.model.Candidat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepo  extends MongoRepository<Candidat, String> {
}
