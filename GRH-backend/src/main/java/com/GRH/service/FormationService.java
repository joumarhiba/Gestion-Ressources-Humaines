package com.GRH.service;

import com.GRH.dto.FormationDto;
import com.GRH.exception.ItemIdNotFoundException;
import com.GRH.exception.NoItemsFoundException;
import com.GRH.mapper.FormationMapper;
import com.GRH.model.Formation;
import com.GRH.repository.FormationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormationService {
    private final FormationMapper formationMapper;
    private final FormationRepo formationRepo;

    public FormationDto createFormation(FormationDto formationDto){
        Formation formation = formationRepo.save(formationMapper.dtoToFormation(formationDto));
        return formationMapper.formationToDto(formation);
    }

    public FormationDto getFormationById(Long id){
        Formation formation = formationRepo.findById(id).orElseThrow(() -> new ItemIdNotFoundException("this id Formation not found"));
        return new FormationDto(formation.getTopic(), formation.getDescription(), formation.getDuration(), formation.getNbStudent());
    }

    public List<FormationDto> getAllFormations() throws NoItemsFoundException {
        List<Formation> formations = formationRepo.findAll();
        if(formations.isEmpty()){
            throw new NoItemsFoundException("No formation Record was stored in DB...");
        }
        List<FormationDto> formationDtos =
                formations.stream().map(formation -> new FormationDto(
                                formation.getTopic(),formation.getDescription(),formation.getDuration(), formation.getNbStudent()
                        ))
                        .collect(Collectors.toList());
        return formationDtos;
    }

    public FormationDto updateFormation(FormationDto formationDto) {
        Formation formation = formationRepo.findById(Long.parseLong(formationDto.id()))
                .orElseThrow(() -> new ItemIdNotFoundException("this id Formation not found"));
        Formation updatedFormation = formationRepo.save(formationMapper.dtoToFormation(formationDto));
        return formationMapper.formationToDto(updatedFormation);
    }
}
