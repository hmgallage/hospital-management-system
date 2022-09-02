package com.hmsystem.controller;

import com.hmsystem.Service.Appointmentservice;
import com.hmsystem.model.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private Appointmentservice appointmentservice;

    public AppointmentController(Appointmentservice appointmentservice){

        this.appointmentservice = appointmentservice;
    }

    //doctor REST API
    //create
    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<Appointment>(appointmentservice.saveAppointment(appointment), HttpStatus.CREATED);
    }


    //get
    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentservice.getAllAppointments();
    }


    //update doctors
    // http://localhost:8080/api/Appointment/1
    @PutMapping("{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id
            , @RequestBody Appointment appointment){
        return new ResponseEntity<Appointment>(appointmentservice.updateAppointment(appointment, id), HttpStatus.OK);

    }


    //Delete doctors
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") long id){

        // delete doctor from DB
        appointmentservice.deleteAppointment(id);

        return new ResponseEntity<String>("Appointment Record deleted successfully!.", HttpStatus.OK);
    }
}
