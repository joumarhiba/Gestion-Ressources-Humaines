package com.GRH.repository;


import com.GRH.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatRepo  extends JpaRepository<Candidat, Long> {
    Optional<Candidat> findByEmail(String email);

}
