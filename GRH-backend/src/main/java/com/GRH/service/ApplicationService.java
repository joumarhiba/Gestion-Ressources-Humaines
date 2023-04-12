package com.GRH.service;

import com.GRH.dto.ApplicationDto;

import com.GRH.exception.ItemIdNotFoundException;
import com.GRH.exception.NoItemsFoundException;
import com.GRH.mapper.ApplicationMapper;
import com.GRH.model.Application;

import com.GRH.model.Offre;
import com.GRH.repository.ApplicationRepo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.microvisor.v1.App;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {
    private final ApplicationRepo applicationRepo;
    private final ApplicationMapper applicationMapper;
//

    public Application createApplication(Application application){

        application.setStatus("Reçu");
        Application applicationSaved = applicationRepo.save(application);
        return applicationSaved;
    }

    public String trashApplicationById(Long id){
         applicationRepo.updateApplicationSetStatusForId(id);
         return "le status est changé pour "+ id;
    }

    public String uploadApplicationById(Long id){
        applicationRepo.updateApplicationStatusForId(id);
        return "le status est changé pour "+ id;
    }

    public List<ApplicationDto> getAllReceivedApps() throws NoItemsFoundException {
        List<Application> applications = applicationRepo.findAllReceivedApplication();
        if(applications.isEmpty()){
            throw new NoItemsFoundException("No offer Record was Found in DB...");
        }
        List<ApplicationDto> applicationDtos =
                applications.stream().map(app -> new ApplicationDto(
                                app.getId(), app.getStatus(), app.getTitle(), app.getProfile(), app.getCv()
                        ))
                        .collect(Collectors.toList());
        return applicationDtos;
    }

    public Long getReceivedApplications() throws NoItemsFoundException {
        Long receivedApplication = applicationRepo.findReceivedApplication();
        Long allApplication = applicationRepo.findAllApplication();
        if(receivedApplication == 0){
            throw new NoItemsFoundException("No application Record was Found in DB...");
        }
        return receivedApplication * 100 / allApplication;
    }

    public Long getTrashedApplications() throws NoItemsFoundException {
        int trashedApplication = applicationRepo.findTrashedApplication();
        Long allApplication = applicationRepo.findAllApplication();
        if(trashedApplication == 0){
            throw new NoItemsFoundException("No application Record was Found in DB...");
        }
        return trashedApplication * 100 / allApplication ;
    }
    public Long getUploadedApplications() throws NoItemsFoundException {
        Long uploadedApplication = applicationRepo.findUploadedApplication();
        Long allApplication = applicationRepo.findAllApplication();
        if(uploadedApplication == 0) {
            throw new NoItemsFoundException("No application Record was Found in DB...");
        }
        return uploadedApplication * 100 / allApplication ;
    }


    @Value("${TWILIO_SID}")
    String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;
    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;



    @PostConstruct
    public void setup(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    }
    public String processSms(){
        Message message = Message.creator(
                new PhoneNumber("0657807019"),new PhoneNumber(OUTGOING_SMS_NUMBER), "ceci est un text msg").create();
        return message.getStatus().toString();
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
