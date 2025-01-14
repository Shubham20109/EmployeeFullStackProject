package javaGuides.ems.services.impl;

import javaGuides.ems.dto.EmployeeDTO;
import javaGuides.ems.entity.Employee;
import javaGuides.ems.mapper.EmployeeMapper;
import javaGuides.ems.repository.EmployeeRepository;
import javaGuides.ems.services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServicesImpl implements EmployeeServices {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDTO);
        Employee saveEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(saveEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found Employee this Id "+id));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployeeData(Long id, EmployeeDTO employeeDTO) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found Employee this Id "+id));
        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        Employee employeeUpdate=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employeeUpdate);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found Employee this Id "+id));
        employeeRepository.deleteById(id);
    }


}
