package id.co.indivara.jdt12.hospitalindivara.service.implementasi;
import id.co.indivara.jdt12.hospitalindivara.model.dto.GetAllRecordData;
import id.co.indivara.jdt12.hospitalindivara.model.dto.FormRecord;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Record;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Treatment;
import id.co.indivara.jdt12.hospitalindivara.repo.AppointmentRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.DoctorRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.RecordRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.TreatmentRepository;
import id.co.indivara.jdt12.hospitalindivara.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImplementation implements RecordService {

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Record createRecord(FormRecord formRecord) {
        //Treatment treatment=treatmentRepository.findById(record.getTreatment().).orElseThrow(()-> new RuntimeException("Treatment does not exist"));
//        List<Treatment> treatments = record.getTreatment();
//        //pengecekan treatment dari record
//        for (Treatment t : treatments) {
//            Treatment treatment = treatmentRepository.findById(t.getId()).orElseThrow(() -> new RuntimeException("Treatment does not exist"));
//        }
        Appointment appointment = appointmentRepository.findById(formRecord.getAppointmentId()).get();
        Treatment treatment = treatmentRepository.findById(formRecord.getTreatmentId()).get();
        appointment.setRegisterStatus(true);
        Doctor doctor=doctorRepository.findById(appointment.getDoctor().getId()).get();
        doctor.setDoctorReady(true);
        doctorRepository.save(doctor);
        appointmentRepository.save(appointment);
        Record record = Record.builder().
                appointment(appointment).
                treatment(treatment).
                build();
        recordRepository.save(record);
        return record;
    }


    @Override
    public List<GetAllRecordData> getAllRecordData() {
        List<Record> records = (List<Record>) recordRepository.findAll();
        List<GetAllRecordData> getAllRecordData = new ArrayList<>();
        for (Record record : records) {
            GetAllRecordData getAllRecordData1 = new GetAllRecordData();
            getAllRecordData1.setNamePatient(record.getAppointment().getPatient().getNamePatient());
            getAllRecordData1.setNameDoctor(record.getAppointment().getDoctor().getNameDoctor());
            getAllRecordData1.setSpecialistName(record.getAppointment().getDoctor().getSpecialization().getSpecialistName());
            getAllRecordData1.setComplaint(record.getAppointment().getComplaint());
            getAllRecordData1.setRegisterStatus(true);
            getAllRecordData1.setTypeOfTreatment(record.getTreatment().getTypeOfTreatment());
            getAllRecordData1.setDiagnosis(record.getTreatment().getDiagnosis());
            getAllRecordData.add(getAllRecordData1);
        }
        return getAllRecordData;
    }
}