package com.employees.myemployees.Controllers;

import com.employees.myemployees.Models.DTO.ProjectDTO;
import com.employees.myemployees.Models.DTO.TaskDTO;
import com.employees.myemployees.Models.GeneralResponse;
import com.employees.myemployees.Services.TaskServicesINT;
import com.employees.myemployees.Util.PreperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
   private TaskServicesINT taskServices;

    TaskController(TaskServicesINT taskServices)
    {
       this.taskServices = taskServices;
    }

    @RequestMapping (path = "/getalltasks", method = RequestMethod.GET)
    public List<TaskDTO> GetAllProjects( ) {
        return taskServices.findAll();
    }


    @RequestMapping (path = "/gettaskbyid", method = RequestMethod.GET)
    public ResponseEntity<?> getbyID(
            @RequestParam long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(taskServices.findById(id),"Success","200");
        return new ResponseEntity<>(generalResponse , HttpStatus.OK);
    }


    @RequestMapping (path = "/addtasktdata", method = RequestMethod.POST)
    public ResponseEntity<?> AddDat(@RequestBody TaskDTO taskDTO) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(taskServices.save(taskDTO) ,"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }


    @RequestMapping (path = "/deletetaskdata", method = RequestMethod.POST)
    public ResponseEntity<?> DeleteDat(@RequestParam Long id) {
        GeneralResponse generalResponse = PreperResponse.preperResponse(taskServices.deleteById(id),"Success","200");
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }


}
