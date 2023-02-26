package com.GRH.mapper;

import com.GRH.Request.CandidatRequest;
import com.GRH.dto.CandidatDto;
import com.GRH.model.Candidat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CandidatMapper {
    CandidatDto CandidatToCandidatDto(Candidat candidat);
    Candidat CandidatDtoToCandidat(CandidatDto candidatDto);
    CandidatDto requestToDto(CandidatRequest request);
}
