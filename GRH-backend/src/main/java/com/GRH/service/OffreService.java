package com.GRH.service;

import com.GRH.dto.OffreDto;
import com.GRH.exception.ItemIdNotFoundException;
import com.GRH.exception.NoItemsFoundException;
import com.GRH.mapper.OffreMapper;
import com.GRH.model.Offre;
import com.GRH.model.OffreStatus;
import com.GRH.repository.OffreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OffreService {

    private final OffreRepo offreRepo;
    private final OffreMapper offreMapper;

    public OffreDto createOffre(OffreDto offreDto){
//        offreMapper.dtoToOffre(offreDto).setDatePublication(LocalDateTime.now());
//        offreMapper.dtoToOffre(offreDto).setStatus(OffreStatus.NonChecked);
        OffreDto savedOffreDto = new OffreDto(
                offreDto.title(), offreDto.description(), offreDto.contrat(),
                new Date(), OffreStatus.NonChecked);
        Offre offre = offreRepo.save(offreMapper.dtoToOffre(savedOffreDto));
        return offreMapper.offreToDto(offre);
    }


    public List<OffreDto> getAllOffres() throws NoItemsFoundException {
        List<Offre> offres = offreRepo.findAll();
        if(offres.isEmpty()){
            throw new NoItemsFoundException("No offer Record was Found in DB...");
        }
        List<OffreDto> offreDtos =
                offres.stream().map(offre -> new OffreDto(
                                offre.getId(), offre.getTitle(),offre.getDescription(), offre.getContrat(),offre.getDatePublication(), offre.getStatus()
                        ))
                        .collect(Collectors.toList());
        return offreDtos;
    }

    public OffreDto updateOffre(OffreDto offreDto) {
        Offre offre = offreRepo.findById(offreDto.id())
                .orElseThrow(() -> new ItemIdNotFoundException("this id Offre not found"));
        Offre updatedOffre = offreRepo.save(offreMapper.dtoToOffre(offreDto));
        return offreMapper.offreToDto(updatedOffre);
    }
    public Offre deleteOffre(Long id) {
        Offre offre = offreRepo.findById(id)
                .orElseThrow(() -> new ItemIdNotFoundException("This id Offre not found"));
        return offre;
    }
}
