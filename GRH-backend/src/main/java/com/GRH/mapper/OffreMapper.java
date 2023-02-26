package com.GRH.mapper;

import com.GRH.Request.OffreRequest;
import com.GRH.dto.OffreDto;
import com.GRH.model.Offre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")


public interface OffreMapper {
    OffreDto offreToDto(Offre offre);
    Offre dtoToOffre(OffreDto offreDto);
    OffreDto requestToDto(OffreRequest request);
}
