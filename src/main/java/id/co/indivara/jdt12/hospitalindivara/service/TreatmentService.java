package id.co.indivara.jdt12.hospitalindivara.service;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Treatment;

import java.util.List;

public interface TreatmentService {
//    Boolean recordTreatment (FormAppointment formTindakan);
    Treatment createTreatment (Treatment treatment);
    Treatment updateTreatment (Treatment treatment, Integer id);
    Treatment getIdTreatment (Integer id);
    String removeTreatment (Integer id);
    List<Treatment> getAllTreatment();
}
