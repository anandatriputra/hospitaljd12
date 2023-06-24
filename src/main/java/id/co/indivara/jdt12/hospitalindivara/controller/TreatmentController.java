package id.co.indivara.jdt12.hospitalindivara.controller;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Treatment;
import id.co.indivara.jdt12.hospitalindivara.service.TreatmentService;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/treatment")
@RestController
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;
    @PostMapping ("/createTreatment")
    public ResponseEntity<Treatment> createTreatment (@RequestBody Treatment treatment){
        return new ResponseEntity<>(treatmentService.createTreatment(treatment), HttpStatus.CREATED);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Treatment>updateTreatment (@RequestBody Treatment treatment, @PathVariable ("id") Integer id){
        return new ResponseEntity<>(treatmentService.updateTreatment(treatment,id),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getId/{id}")
    public ResponseEntity<Treatment>getIdTreatment(@PathVariable ("id") Integer id){
        return new ResponseEntity<>(treatmentService.getIdTreatment(id), HttpStatus.OK);
    }
    @DeleteMapping("/removePatient/{id}")
    public ResponseEntity<String> removeTreatment (@PathVariable ("id") Integer id){
        return new ResponseEntity<>(treatmentService.removeTreatment(id),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getAllPatient")
    public ResponseEntity <List<Treatment>> getAllTreatment(){
        return new ResponseEntity<>(treatmentService.getAllTreatment(),HttpStatus.OK);
    }
}
