package com.GRH.repository;

import com.GRH.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepo  extends JpaRepository<Candidat, Long> {
}
