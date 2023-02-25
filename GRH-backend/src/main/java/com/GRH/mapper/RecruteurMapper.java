package com.GRH.mapper;


import com.GRH.Request.RecruteurRequest;
import com.GRH.dto.RecruteurDto;
import com.GRH.model.Recruteur;

public interface RecruteurMapper {
    RecruteurDto recruteurToDto(Recruteur recruteur);
    Recruteur dtoToRecruteur(RecruteurDto recruteurDto);
    RecruteurDto requestToDto(RecruteurRequest request);
}
