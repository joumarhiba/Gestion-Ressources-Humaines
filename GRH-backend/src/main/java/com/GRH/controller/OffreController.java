package com.GRH.controller;

import com.GRH.dto.OffreDto;
import com.GRH.dto.RecruteurDto;
import com.GRH.service.OffreService;
import com.GRH.util.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/offre")
@RequiredArgsConstructor

public class OffreController {

    private final OffreService offreService;
    HttpResponse response;


    @GetMapping
    ResponseEntity<HttpResponse> getOffres() {
        List<OffreDto> recruteurDtos = offreService.getAllOffres();
        response = new HttpResponse(HttpStatus.OK.value(), Collections.singletonMap("offers", recruteurDtos),"All offers are retrieved Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createOffre(@RequestBody OffreDto offreDto){
        OffreDto savedOffer = offreService.createOffre(offreDto);
        response = new HttpResponse(OK.value(),savedOffer, "one offer was added Successfully to db");
        return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpResponse> updateOffre(@RequestBody OffreDto offreDto) {
        OffreDto updatedOffre = offreService.updateOffre(offreDto);
        HttpResponse response = new HttpResponse(HttpStatus.OK.value(), updatedOffre, "Offre updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpResponse> deleteOffre(@PathVariable Long id) {
        offreService.deleteOffre(id);
        HttpResponse response = new HttpResponse(HttpStatus.OK.value(), "Offre deleted successfully with id : "+id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
