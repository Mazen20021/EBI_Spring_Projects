package com.employees.myemployees.Controllers;

import com.employees.myemployees.Models.DTO.EmployeesDTO;
import com.employees.myemployees.Models.DTO.ProjectDTO;
import com.employees.myemployees.Models.GeneralResponse;
import com.employees.myemployees.Services.ProjectServiceINT;
import com.employees.myemployees.Util.PreperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/project")
public class ProjectController {

    ProjectServiceINT projectServices;
    @Autowired
    ProjectController(ProjectServiceINT projectServices)
    {
        this.projectServices = projectServices;
    }


    @RequestMapping (path = "/GetAllProjects", method = RequestMethod.GET)
    public List<ProjectDTO> GetAllProjects( ) {
        return projectServices.findAll();
    }

    @RequestMapping (path = "/GetprojectByID", method = RequestMethod.GET)
    public ResponseEntity<?> getbyID(
            @RequestParam long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(projectServices.findById(id),"Success","200");
        return new ResponseEntity<>(generalResponse , HttpStatus.OK);
    }

    @RequestMapping (path = "/AddProjectData", method = RequestMethod.POST)
    public ResponseEntity<?> AddDat(@RequestBody  ProjectDTO projectDTO) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(projectServices.save(projectDTO) ,"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @RequestMapping (path = "/DeleteProjectData", method = RequestMethod.POST)
    public ResponseEntity<?> DeleteDat(@RequestParam Long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(projectServices.deleteById(id),"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @RequestMapping (path = "/getprojectbytaskid" , method = RequestMethod.POST)
    public List<ProjectDTO> GetEmployeeByProjectID(@RequestParam Long taskID) {
        return projectServices.getProjectByTaskID(taskID);
    }

}
