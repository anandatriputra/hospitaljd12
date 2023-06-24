package id.co.indivara.jdt12.hospitalindivara.model.dto;

import lombok.Data;

@Data
public class GetAllRecordData {
    private String namePatient;
    private String nameDoctor;
    private String specialistName;
    private String complaint;
    private Boolean registerStatus;
    private String typeOfTreatment;
    private String diagnosis;

}
