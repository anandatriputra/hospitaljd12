package id.co.indivara.jdt12.hospitalindivara.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Treatment;
import lombok.Data;

import javax.persistence.*;
@Data
public class FormRecord {
    private Integer appointmentId;
    private Integer treatmentId;

}
