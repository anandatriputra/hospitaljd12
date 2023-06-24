package id.co.indivara.jdt12.hospitalindivara.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
public class FormAppointment {
    private String specialistName;
    private Integer patientId;
    private String complaint;
    private LocalDate date;
}
