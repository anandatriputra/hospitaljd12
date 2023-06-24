package id.co.indivara.jdt12.hospitalindivara.repo;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    List<Doctor> findAllBySpecializationAndDoctorReadyTrue(Specialization specialization);
}
