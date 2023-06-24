//package id.co.indivara.jdt12.hospitalindivara.service.implementasi;
//
//import id.co.indivara.jdt12.hospitalindivara.exception.NotFoundException;
//import id.co.indivara.jdt12.hospitalindivara.model.dto.FormAppointment;
//import id.co.indivara.jdt12.hospitalindivara.model.entity.*;
//import id.co.indivara.jdt12.hospitalindivara.repo.*;
//import id.co.indivara.jdt12.hospitalindivara.service.AdminService;
//import id.co.indivara.jdt12.hospitalindivara.service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//
//@Service
//public class AdminServiceImplementation implements AdminService {
//    @Autowired
//    PatientRepository patientRepository;
//    @Autowired
//    DoctorRepository doctorRepository;
//    @Autowired
//    TreatmentRepository treatmentRepository;
//    @Autowired
//    AppointmentRepository appointmentRepository;
//
//
//    @Override
//    public Boolean registerVisit(FormAppointment formAppointment) {
//        Patient patient = patientRepository.findById(formAppointment.getRegistId()).orElseThrow(()->new NotFoundException("patient not regits"));
//        Doctor doctor = doctorRepository.findFirstBySpecialistAndTersediaTrue(formAppointment.getDokterId());
//        if (patient != null&& !doctor.equals(null)) {
//                appointmentRepository.save(Appointment.builder()
//                        .tanggalRegistrasi(formRegistrasi.getTanggalKetemu())
//                        .patient(patient)
//                        .doctor(doctor).build());
//                return true;
//            }
//            return false;
//        }
//
//
//
//    @Override
//    public Boolean recordTreatment(FormAppointment formAppointment) {
//        Patient patient = patientRepository.findById(formAppointment.getRegistId()).get();
//        Treatment treatment = treatmentRepository.findByTypeOfTreatment(formAppointment.getJenisTreatment());
//        Appointment appointment = appointmentRepository.findByPatient(patient.getNamePatient());
//        if (patient != null&& !treatment.equals(null)) {
//            appointmentRepository.save(Appointment.builder()
//                    .doctorId()
//                    .registrasi(registrasi)
//                    .doctorId(registrasi.getDoctor())
//                    .date(LocalDate.now())
//                    .patientId(patient)
//                    .build());
//        }
//        return true;
//    }
//
//}
