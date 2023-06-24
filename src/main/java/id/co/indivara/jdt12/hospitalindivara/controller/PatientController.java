package id.co.indivara.jdt12.hospitalindivara.controller;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;
import id.co.indivara.jdt12.hospitalindivara.repo.PatientRepository;
//import id.co.indivara.jdt12.hospitalindivara.service.AdminService;
import id.co.indivara.jdt12.hospitalindivara.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/patient")
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/createPatient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
    return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable("id") Integer Id) {
        return new ResponseEntity<>(patientService.updatePatient(patient, Id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity <Patient> getIdPatient(@PathVariable ("id") Integer id){
        return new ResponseEntity<>(patientService.getIdPatient(id), HttpStatus.OK);
    }
    @DeleteMapping("/removePatient/{id}")
    public ResponseEntity<String> removePatient (@PathVariable ("id") Integer id){
        return new ResponseEntity<>(patientService.removePatient(id),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getAllPatient")
    public ResponseEntity <List<Patient>> getAllPatient(){
        return new ResponseEntity<>(patientService.getAllPatient(),HttpStatus.OK);
    }
}
