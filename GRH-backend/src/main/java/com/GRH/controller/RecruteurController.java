package com.GRH.controller;

import com.GRH.dto.RecruteurDto;
import com.GRH.model.Recruteur;
import com.GRH.service.RecruteurService;
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
@RequestMapping("/api/v1/recruteur")
@RequiredArgsConstructor
public class RecruteurController {
    private final RecruteurService recruteurService;
    HttpResponse response;


    @GetMapping
    ResponseEntity<HttpResponse> getRecruteurs() {
        List<RecruteurDto> recruteurDtos = recruteurService.getAllRecruteurs();

        response = new HttpResponse(HttpStatus.OK.value(),
                Collections.singletonMap("recruteurs", recruteurDtos),
                "Successfully retrieved records"
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<HttpResponse> createRecruteur(@RequestBody RecruteurDto recruteurDto){
        RecruteurDto savedRecruteur = recruteurService.createRecruteur(recruteurDto);
        response = new HttpResponse(OK.value(),savedRecruteur, "one recruteur was added Successfully");
      return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpResponse> updateRecruteur(@RequestBody RecruteurDto recruteurDto) {
        RecruteurDto updatedRecruteur = recruteurService.updateRecruteur(recruteurDto);
        HttpResponse response = new HttpResponse(HttpStatus.OK.value(), updatedRecruteur, "Recruteur updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
