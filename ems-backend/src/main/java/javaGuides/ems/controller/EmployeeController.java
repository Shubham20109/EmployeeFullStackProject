package javaGuides.ems.controller;

import javaGuides.ems.dto.EmployeeDTO;
import javaGuides.ems.services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private EmployeeServices employeeServices;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO saveEmployee=employeeServices.createEmployee(employeeDTO);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/getData/{id}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable("id") Long id){
        EmployeeDTO employeeDTO=employeeServices.getEmployeeById(id);

        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/allEmployeesList")
    public ResponseEntity<List<EmployeeDTO>> allGet(){
        List<EmployeeDTO> employeeDTOS=employeeServices.getAllEmployee();
        return ResponseEntity.ok(employeeDTOS);
    }

    @PutMapping("/updateData/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")Long id,@RequestBody EmployeeDTO employeeDTO ){
        EmployeeDTO updatedData=employeeServices.updateEmployeeData(id,employeeDTO);
        return ResponseEntity.ok(updatedData);
    }

    @DeleteMapping("/deltedEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id")Long id){
        employeeServices.deleteEmployee(id);
        return ResponseEntity.ok("this employee is deleted "+id);
    }

}

