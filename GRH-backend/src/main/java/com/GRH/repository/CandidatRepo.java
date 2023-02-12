package com.GRH.repository;

import com.GRH.model.Candidat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatRepo  extends MongoRepository<Candidat, String> {
}
