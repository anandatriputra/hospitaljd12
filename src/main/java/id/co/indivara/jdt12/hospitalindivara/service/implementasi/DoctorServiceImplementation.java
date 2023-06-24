package id.co.indivara.jdt12.hospitalindivara.service.implementasi;

import id.co.indivara.jdt12.hospitalindivara.exception.NotFoundException;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.repo.DoctorRepository;
import id.co.indivara.jdt12.hospitalindivara.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImplementation implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        doctor.setDoctorReady(true);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Integer id, Doctor doctor) {
        Doctor updatedDoctor = doctorRepository.findById(id).orElse(null);

        if (updatedDoctor != null) {
            updatedDoctor.setNameDoctor(doctor.getNameDoctor());
            updatedDoctor.setAddress(updatedDoctor.getAddress());
            updatedDoctor.setNumberPhone(doctor.getNumberPhone());
            updatedDoctor.setDoctorReady(doctor.getDoctorReady());

            return updatedDoctor;
        }

        throw new RuntimeException("Doctor does not exist.");
    }

    @Override
    public Doctor getIdDoctor(Integer id) {

        return doctorRepository.findById(id).get();
    }

    @Override
    public String removeDoctor(Integer id) {
       doctorRepository.deleteById(id);
       return "deleted.";
    }

    @Override
    public List<Doctor> getAllDoctor() {

        return (List<Doctor>) doctorRepository.findAll();
    }
}

