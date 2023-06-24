package id.co.indivara.jdt12.hospitalindivara.controller;

import id.co.indivara.jdt12.hospitalindivara.model.dto.FormRecord;
import id.co.indivara.jdt12.hospitalindivara.model.dto.GetAllRecordData;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Record;
import id.co.indivara.jdt12.hospitalindivara.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/record")
@RestController
public class RecordController {
    @Autowired
    RecordService recordService;

    @PostMapping("/createRecord")
    public ResponseEntity<Record> createRecord(@RequestBody FormRecord formRecord) {
        return new ResponseEntity<>(recordService.createRecord(formRecord), HttpStatus.CREATED);
    }
    @GetMapping("/getAllRecord")
    public ResponseEntity<List<GetAllRecordData>> getAllRecord (){
        return new ResponseEntity<>(recordService.getAllRecordData(),HttpStatus.OK);
    }
}
