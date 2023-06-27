package id.co.indivara.jdt12.hospitalindivara.service.implementasi;

import id.co.indivara.jdt12.hospitalindivara.exception.NotFoundException;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Record;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Treatment;
import id.co.indivara.jdt12.hospitalindivara.repo.RecordRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.TreatmentRepository;
import id.co.indivara.jdt12.hospitalindivara.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatementServiceImplementation implements TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;
    @Autowired
    RecordRepository recordRepository;
    @Override
    public Treatment createTreatment(Treatment treatment) {
        Treatment treatments= Treatment.builder().
                diagnosis(treatment.getDiagnosis()).
                medicine(treatment.getMedicine()).
                typeOfTreatment(treatment.getTypeOfTreatment()).
                build();
        return treatmentRepository.save(treatment);
    }

    @Override
    public Treatment updateTreatment(Treatment treatment, Integer id) {
        Treatment updateTreatment= treatmentRepository.findById(id).orElseThrow(() ->new NotFoundException("Treatment does not exist."));
        updateTreatment.setTypeOfTreatment(treatment.getTypeOfTreatment());
        updateTreatment.setDiagnosis(treatment.getDiagnosis());
        updateTreatment.setMedicine(treatment.getMedicine());
        return treatmentRepository.save(updateTreatment);
    }

    @Override
    public Treatment getIdTreatment(Integer id) {
        return treatmentRepository.findById(id).get();
    }

    @Override
    public String removeTreatment(Integer id) {
        treatmentRepository.deleteById(id);
        return "deleted.";
    }

    @Override
    public List<Treatment> getAllTreatment() {
        return (List<Treatment>) treatmentRepository.findAll();
    }
}

