package id.co.indivara.jdt12.hospitalindivara.service;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient ( Patient patient);
    Patient updatePatient ( Patient patient, Integer id);
    Patient getIdPatient(Integer id);
    String removePatient (Integer id);
    List<Patient> getAllPatient();
}
