package id.co.indivara.jdt12.hospitalindivara.controller;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import id.co.indivara.jdt12.hospitalindivara.repo.DoctorRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.SpecializationRepository;
import id.co.indivara.jdt12.hospitalindivara.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@RestController
public class   DoctorController  {

    @Autowired
    SpecializationRepository specializationRepository;
    @Autowired
    DoctorService doctorService;

     @PostMapping("/createdoctors/{specialistId}")
     public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor, @PathVariable ("specialistId") Integer id){
        Specialization specialization = specializationRepository.findById(id).orElseThrow(() -> new RuntimeException("Specialization not found."));
        doctor.setSpecialization(specialization);
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
     }
     @PutMapping("/update/{id}")
     public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable ("id") Integer id){
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctor), HttpStatus.NO_CONTENT);
     }
     @GetMapping("/getId/{id}")
     public ResponseEntity<Doctor> getIdDoctor(@PathVariable ("id") Integer id){
        return new ResponseEntity<>(doctorService.getIdDoctor(id), HttpStatus.OK);
     }

     @DeleteMapping("/removeDoctor/{id}")
     public ResponseEntity<String> removeDoctor(@PathVariable ("id")Integer id){
        return new ResponseEntity<>(doctorService.removeDoctor(id), HttpStatus.NO_CONTENT);
     }
     @GetMapping("/getAllDoctor")
     public ResponseEntity<List<Doctor>>  getAllDoctor(){
        return new ResponseEntity<>(doctorService.getAllDoctor(),HttpStatus.OK);
     }
}

