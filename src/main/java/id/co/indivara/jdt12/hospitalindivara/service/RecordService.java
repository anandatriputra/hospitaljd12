package id.co.indivara.jdt12.hospitalindivara.service;

import id.co.indivara.jdt12.hospitalindivara.model.dto.GetAllRecordData;
import id.co.indivara.jdt12.hospitalindivara.model.dto.FormRecord;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Record;

import java.util.List;

public interface RecordService {
    Record createRecord(FormRecord formRecord);

    List<GetAllRecordData> getAllRecordData() ;
}

