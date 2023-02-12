package com.GRH.service;

import com.GRH.model.Recruteur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecruteurService {

    public Recruteur addRecruteur(Recruteur recruteur);
    public List<Recruteur> getAllRecruteurs();
    public void deleteRecruteur();
}
