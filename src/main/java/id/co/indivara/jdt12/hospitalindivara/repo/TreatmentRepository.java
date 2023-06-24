package id.co.indivara.jdt12.hospitalindivara.repo;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Treatment;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentRepository extends CrudRepository<Treatment,Integer> {
    Treatment findByTypeOfTreatment (String typeTreatment);

}
