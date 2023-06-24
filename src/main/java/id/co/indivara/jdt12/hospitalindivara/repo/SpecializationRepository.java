package id.co.indivara.jdt12.hospitalindivara.repo;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Integer> {
    Specialization findBySpecialistName (String specialistName);
}
