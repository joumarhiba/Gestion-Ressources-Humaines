package com.GRH.mapper;

import com.GRH.dto.RecruteurDto;
import com.GRH.model.Recruteur;
import com.GRH.request.RecruteurRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecruteurMapper {
    RecruteurDto recruteurToDto(Recruteur recruteur);
    Recruteur dtoToRecruteur(RecruteurDto recruteurDto);
    RecruteurDto requestToDto(RecruteurRequest request);
}
