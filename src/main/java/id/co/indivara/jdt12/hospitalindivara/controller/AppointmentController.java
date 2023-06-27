package id.co.indivara.jdt12.hospitalindivara.controller;


import id.co.indivara.jdt12.hospitalindivara.model.dto.FormAppointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Record;
import id.co.indivara.jdt12.hospitalindivara.repo.DoctorRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.PatientRepository;
import id.co.indivara.jdt12.hospitalindivara.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/appointment")
@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping ("/createAppointment")
    public ResponseEntity<FormAppointment>createAppointment(@RequestBody FormAppointment formAppointment){
        FormAppointment appointment = appointmentService.createAppointment(formAppointment);
        return new ResponseEntity<>(appointment,HttpStatus.CREATED);
    }
}
