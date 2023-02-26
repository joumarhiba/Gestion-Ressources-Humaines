package com.GRH.repository;

import com.GRH.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OffreRepo extends JpaRepository<Offre, Long> {
}
