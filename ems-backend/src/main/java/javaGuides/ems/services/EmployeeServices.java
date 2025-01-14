package javaGuides.ems.services;

import javaGuides.ems.dto.EmployeeDTO;
import javaGuides.ems.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployeeData(Long id,EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
