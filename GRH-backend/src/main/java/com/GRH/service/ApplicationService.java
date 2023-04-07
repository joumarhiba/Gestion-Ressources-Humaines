package com.GRH.service;

import com.GRH.dto.ApplicationDto;
import com.GRH.mapper.ApplicationMapper;
import com.GRH.model.Application;
import com.GRH.repository.ApplicationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {
    private final ApplicationMapper applicationMapper;
    private final ApplicationRepo applicationRepo;


    public Application createApplication(Application application){

        application.setStatus("Reçu");
        Application applicationSaved = applicationRepo.save(application);
        log.info("get status <<<<<<< "+application.getStatus());
        log.info("mapper ========== "+applicationSaved);
        return applicationSaved;

    }







//    public ApplicationDto createApplication2(ApplicationDto applicationDto){
//        ApplicationDto savedAppDto = new ApplicationDto(
//                "reçu", applicationDto.title(), applicationDto.profile(), applicationDto.cv()
//        );
//        log.info("savedApp :::::::::: "+savedAppDto);
//        Application application = applicationRepo.save(applicationMapper.applicationDtoToApplication(savedAppDto));
//        log.info("mapper ========== "+application);
//        return applicationMapper.applicationToApplicationDto(application);
//    }
}
