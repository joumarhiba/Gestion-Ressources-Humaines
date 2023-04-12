package com.GRH.controller;

import com.GRH.dto.ApplicationDto;
import com.GRH.dto.OffreDto;
import com.GRH.model.Application;
import com.GRH.service.ApplicationService;
import com.GRH.util.HttpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/application")
@RequiredArgsConstructor
@Slf4j

public class ApplicationController {

    private final ApplicationService applicationService;
    HttpResponse response;

    @PostMapping
    public ResponseEntity<HttpResponse> createApplication(@RequestBody Application application){
        log.info("in controller requestBody ======== "+application);
        Application savedApplication = applicationService.createApplication(application);
        response = new HttpResponse(OK.value(),savedApplication , "one application was added Successfully");
        log.info("in controller saved ======== "+savedApplication);
        applicationService.processSms();
        return new ResponseEntity<>(response, CREATED);
    }

    @GetMapping("/all-received")
    ResponseEntity<HttpResponse> getAllReceivedApplications() {
        List<ApplicationDto> applicationDtos = applicationService.getAllReceivedApps();
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("application", applicationDtos),"All received application got Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/received")
    ResponseEntity<HttpResponse> getReceivedApplications() {
        Long applicationDtos = applicationService.getReceivedApplications();
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("application", applicationDtos),"All received application got Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/trashed")
    ResponseEntity<HttpResponse> getTrashedApplications() {
        Long trashedApplications = applicationService.getTrashedApplications();
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("application", trashedApplications),"All trashed application are retrieved Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpResponse> trashApplication(@RequestBody Long id){
        String application = applicationService.trashApplicationById(id);
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("application", application),"status is changed Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/change-to-upload")
    public ResponseEntity<HttpResponse> uploadApplication(@RequestBody Long id){
        String application = applicationService.uploadApplicationById(id);
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("application", application),"status is changed Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/uploaded")
    ResponseEntity<HttpResponse> getUploadedApplications() {
        Long uploadedApplications = applicationService.getUploadedApplications();
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("application", uploadedApplications),"All uploaded application are retrieved Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
