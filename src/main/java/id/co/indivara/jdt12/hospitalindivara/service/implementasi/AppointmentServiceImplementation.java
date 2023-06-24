package id.co.indivara.jdt12.hospitalindivara.service.implementasi;

import id.co.indivara.jdt12.hospitalindivara.model.dto.FormAppointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import id.co.indivara.jdt12.hospitalindivara.repo.AppointmentRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.DoctorRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.PatientRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.SpecializationRepository;
import id.co.indivara.jdt12.hospitalindivara.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentServiceImplementation implements AppointmentService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    SpecializationRepository specializationRepository;

    @Override
    public Appointment createAppointment(FormAppointment formAppointment) {
        Patient patient = patientRepository.findById(formAppointment.getPatientId()).orElseThrow(() -> new RuntimeException("Patient does not exist."));
        Specialization specialization = specializationRepository.findBySpecialistName(formAppointment.getSpecialistName());
        List<Doctor> doctors = doctorRepository.findAllBySpecializationAndDoctorReadyTrue(specialization);
        Doctor doctor = doctors.stream().findFirst().get();
        doctor.setDoctorReady(false);
        doctorRepository.save(doctor); 
        Appointment appointment = Appointment.builder().
                patient(patient).
                doctor(doctor).
                complaint(formAppointment.getComplaint()).
                registerStatus(false).
                date(formAppointment.getDate()).
                build();
        return appointmentRepository.save(appointment);
    }
}
