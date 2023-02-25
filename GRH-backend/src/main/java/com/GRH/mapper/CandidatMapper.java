package com.GRH.mapper;

import com.GRH.Request.CandidatRequest;
import com.GRH.dto.CandidatDto;
import com.GRH.model.Candidat;

public interface CandidatMapper {
    CandidatDto CandidatToCandidatDto(Candidat candidat);
    Candidat CandidatDtoToCandidat(CandidatDto candidatDto);
    CandidatDto requestToDto(CandidatRequest request);
}
