package com.employees.myemployees.Controllers;

import com.employees.myemployees.Models.DTO.EmployeesDTO;
import com.employees.myemployees.Models.GeneralResponse;
import com.employees.myemployees.Services.EmployeesServicesInt;
import com.employees.myemployees.Util.PreperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {


    EmployeesServicesInt employeesServices;
    @Autowired
    EmployeesController(@Qualifier("emp") EmployeesServicesInt employeesServices)
    {
        this.employeesServices = employeesServices;
    }


    @RequestMapping (method = RequestMethod.GET , path = "/getallemployees")
    public List<EmployeesDTO> getData() {
        return employeesServices.findAll();
    }


    @RequestMapping (path = "/getemployeebyid", method = RequestMethod.GET)
    public ResponseEntity<?> getbyID(
            @RequestParam long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(employeesServices.findById(id),"Success","200");
        return new ResponseEntity<>(generalResponse , HttpStatus.OK);
    }


    @RequestMapping (path = "/addnewemployee", method = RequestMethod.POST)
    public ResponseEntity<?> AddDat(@RequestBody  EmployeesDTO employeesDTO) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(employeesServices.save(employeesDTO) ,"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }


    @RequestMapping (path = "/updateemployee", method = RequestMethod.POST)
    public ResponseEntity<?> UpdateDat(@RequestBody  EmployeesDTO employeesDTO , @RequestParam Long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(employeesServices.update(employeesDTO , id),"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }


    @RequestMapping (path = "/deleteemployee", method = RequestMethod.POST)
    public ResponseEntity<?> DeleteDat(@RequestBody  EmployeesDTO employeesDTO ,  @RequestParam Long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(employeesServices.deleteById(employeesDTO , id),"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @RequestMapping (path = "/AssignProject" , method = RequestMethod.POST)
    public ResponseEntity<?> AssignProject(@RequestParam Long employeeID ,@RequestParam Long projectID) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(employeesServices.assignProject(employeeID,projectID) ,"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @RequestMapping (path = "/getemployeebyprojectid" , method = RequestMethod.POST)
    public List<EmployeesDTO> GetEmployeeByProjectID(@RequestParam Long projectID) {
        return employeesServices.GetEmployeeByProjectID(projectID);
    }


}
