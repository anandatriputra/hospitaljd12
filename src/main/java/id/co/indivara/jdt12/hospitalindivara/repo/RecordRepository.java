package id.co.indivara.jdt12.hospitalindivara.repo;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository <Record, Integer> {
}
