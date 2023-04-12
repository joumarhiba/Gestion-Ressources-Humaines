package com.GRH.repository;

import com.GRH.model.Application;
import com.twilio.rest.microvisor.v1.App;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    @Query("SELECT COUNT(a.status) FROM Application a WHERE a.status = 'Reçu'")
    Long findReceivedApplication();

    @Query("SELECT COUNT(a.status) FROM Application a WHERE a.status = 'Uploaded'")
    Long findUploadedApplication();

    @Query("SELECT COUNT(*) FROM Application a")
    Long findAllApplication();

    @Query("SELECT COUNT(*) FROM Application app WHERE app.status = 'Trashed'")
    int findTrashedApplication();

    @Query("SELECT app FROM Application app WHERE app.status <> 'Trashed'")
    List<Application> findAllReceivedApplication();

    @Modifying
    @Query("UPDATE Application a SET a.status = 'Trashed' WHERE a.id = :id")
    void updateApplicationSetStatusForId(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Application a SET a.status = 'Uploaded' WHERE a.id = :id")
    void updateApplicationStatusForId(@Param("id") Long id);
}
