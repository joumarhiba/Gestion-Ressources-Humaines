package com.GRH.controller;

import com.GRH.dto.FormationDto;
import com.GRH.service.FormationService;
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
@RequestMapping("/api/v1/formation")
@RequiredArgsConstructor
public class FormationController {

    private final FormationService formationService;
    HttpResponse response;


    @GetMapping
    ResponseEntity<HttpResponse> getFormations() {
        List<FormationDto> formations = formationService.getAllFormations();

        response = new HttpResponse(HttpStatus.OK.value(),
                Collections.singletonMap("formations", formations),
                "Successfully retrieved records"
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createFormation(@RequestBody FormationDto formationDto){
        FormationDto savedFormation = formationService.createFormation(formationDto);
        response = new HttpResponse(OK.value(),savedFormation, "one formation was added Successfully");
        return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpResponse> updateRecruteur(@RequestBody FormationDto formationDto) {
        FormationDto updatedFormation = formationService.updateFormation(formationDto);
        HttpResponse response = new HttpResponse(HttpStatus.OK.value(), updatedFormation, "formation updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
