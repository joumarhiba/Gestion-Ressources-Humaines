package com.GRH.mapper;

import com.GRH.Request.FormationRequest;
import com.GRH.dto.FormationDto;
import com.GRH.model.Formation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FormationMapper {
    FormationDto formationToDto(Formation formation);
    Formation dtoToFormation(FormationDto formationDto);
    FormationDto requestToDto(FormationRequest request);
}
