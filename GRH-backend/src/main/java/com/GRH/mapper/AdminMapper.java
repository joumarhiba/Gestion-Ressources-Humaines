package com.GRH.mapper;

import com.GRH.Request.AdminRequest;
import com.GRH.dto.AdminDto;
import com.GRH.model.Admin;

public interface AdminMapper {
    AdminDto adminToAdminDto(Admin store);
    Admin adminDtoToAdmin(AdminDto storeDto);
    AdminDto requestToDto(AdminRequest request);

}
