package id.co.indivara.jdt12.hospitalindivara.controller;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import id.co.indivara.jdt12.hospitalindivara.repo.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialization")
public class SpecializationController {
    @Autowired
    SpecializationRepository specializationRepository;

    @PostMapping("/createspecialist")
    public ResponseEntity<Specialization> createSpecialization(@RequestBody Specialization specialization) {
        return new ResponseEntity<>(specializationRepository.save(specialization), HttpStatus.CREATED);
    }
}
