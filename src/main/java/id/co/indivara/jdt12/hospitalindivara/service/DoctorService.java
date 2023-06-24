package id.co.indivara.jdt12.hospitalindivara.service;


import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;

import java.util.List;

public interface DoctorService {
    Doctor createDoctor (Doctor doctor);
    Doctor updateDoctor (Integer id, Doctor doctor);
    Doctor getIdDoctor(Integer id);
    String removeDoctor (Integer id);
    List<Doctor> getAllDoctor();
}
