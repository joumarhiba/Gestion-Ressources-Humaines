package com.GRH.controller;

import com.GRH.dto.CandidatDto;
import com.GRH.model.Candidat;
import com.GRH.service.CandidatService;
import com.GRH.util.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/candidat")
@RequiredArgsConstructor
public class CandidatController {
    HttpResponse response;

    private final CandidatService candidatService;

    @PostMapping
    public ResponseEntity<HttpResponse> createCandidat(@RequestBody Candidat candidat){
        Candidat savedCandidat = candidatService.createCandidat(candidat);
        response = new HttpResponse(OK.value(),savedCandidat, "one candidat was added Successfully");
        return new ResponseEntity<>(response, CREATED);
    }
}
