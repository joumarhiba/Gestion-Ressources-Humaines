package com.GRH.mapper;

import com.GRH.Request.ApplicationRequest;
import com.GRH.dto.ApplicationDto;
import com.GRH.model.Application;

public interface ApplicationMapper {
    Application applicationDtoToApplication(ApplicationDto applicationDto);
    ApplicationDto applicationToApplicationDto(Application application);
    ApplicationDto requestToDto(ApplicationRequest request);
}
