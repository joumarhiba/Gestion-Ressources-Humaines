package com.GRH.service;

import com.GRH.dto.RecruteurDto;
import com.GRH.exception.NoItemsFoundException;
import com.GRH.exception.ItemIdNotFoundException;
import com.GRH.mapper.RecruteurMapper;
import com.GRH.model.Recruteur;
import com.GRH.model.UserRole;
import com.GRH.repository.RecruteurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecruteurService {
    private final RecruteurRepository recruteurRepository;
    private final RecruteurMapper recruteurMapper;

    public RecruteurDto createRecruteur(RecruteurDto recruteurDto){
        recruteurMapper.dtoToRecruteur(recruteurDto).setRole(UserRole.RECRUTEUR);
        Recruteur recruteur = recruteurRepository.save(recruteurMapper.dtoToRecruteur(recruteurDto));
        log.info("----------------- "+recruteurMapper.dtoToRecruteur(recruteurDto));
        return recruteurMapper.recruteurToDto(recruteur);
    }


    public List<RecruteurDto> getAllRecruteurs() throws NoItemsFoundException {
        List<Recruteur> recruteurs = recruteurRepository.findAll();
        if(recruteurs.isEmpty()){
            throw new NoItemsFoundException("No recruteur Record was Found in DB...");
        }
        List<RecruteurDto> recruteurDtos =
                recruteurs.stream().map(recruteur -> new RecruteurDto(
                                recruteur.getUsername(),
                                recruteur.getEmail(),
                                recruteur.getPassword(),
                                recruteur.getRole()
                        ))
                        .collect(Collectors.toList());
        return recruteurDtos;
    }

    public RecruteurDto updateRecruteur(RecruteurDto recruteurDto) {
        Recruteur recruteur = recruteurRepository.findById(Long.parseLong(recruteurDto.id()))
                .orElseThrow(() -> new ItemIdNotFoundException("Recruteur not found"));
        Recruteur updatedRecruteur = recruteurRepository.save(recruteurMapper.dtoToRecruteur(recruteurDto));
        return recruteurMapper.recruteurToDto(updatedRecruteur);
    }
}
