package id.co.indivara.jdt12.hospitalindivara.service.implementasi;

import id.co.indivara.jdt12.hospitalindivara.exception.NotFoundException;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;
import id.co.indivara.jdt12.hospitalindivara.repo.PatientRepository;
import id.co.indivara.jdt12.hospitalindivara.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
       return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient, Integer id) {
        Patient patDb = patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient does not exist."));
        patDb.setNamePatient(patient.getNamePatient());
        patDb.setId(patient.getId());
        patDb.setNumberPhone(patient.getNumberPhone());
        patDb.setNumberKtp(patient.getNumberKtp());
        patDb.setAddress(patient.getAddress());
        patDb.setGender(patient.getGender());
    return patientRepository.save(patDb);
    }

    @Override
    public Patient getIdPatient(Integer id) {

        return patientRepository.findById(id).get();
    }

    @Override
    public String removePatient(Integer id) {
       patientRepository.deleteById(id);
       return "deleted.";
    }

    @Override
    public List<Patient> getAllPatient() {

        return (List<Patient>) patientRepository.findAll();
    }
}
