package com.GRH.repository;

import com.GRH.model.Application;
import com.twilio.rest.microvisor.v1.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    @Query("SELECT COUNT(a.status) FROM Application a WHERE a.status = 'Reçu'")
    Long findReceivedApplication();

    @Query("SELECT COUNT(*) FROM Application app WHERE app.status = 'Trashed'")
    int findTrashedApplication();

    @Query("SELECT app FROM Application app WHERE app.status = 'Trashed'")
    List<Application> findAllTrashedApplication();

}
