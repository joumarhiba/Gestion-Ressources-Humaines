package com.GRH.controller;

import com.GRH.dto.ApplicationDto;
import com.GRH.model.Application;
import com.GRH.service.ApplicationService;
import com.GRH.util.HttpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        response = new HttpResponse(OK.value(),savedApplication, "one application was added Successfully");
        log.info("in controller seaved ======== "+savedApplication);
        return new ResponseEntity<>(response, CREATED);
    }
}
