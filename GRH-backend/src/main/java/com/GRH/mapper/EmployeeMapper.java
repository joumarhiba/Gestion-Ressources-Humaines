package com.GRH.mapper;


import com.GRH.Request.EmployeeRequest;
import com.GRH.dto.EmployeeDto;
import com.GRH.model.Employee;

public interface EmployeeMapper {
    EmployeeDto employeeToEmployeeDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeDto requestToDto(EmployeeRequest request);
}
