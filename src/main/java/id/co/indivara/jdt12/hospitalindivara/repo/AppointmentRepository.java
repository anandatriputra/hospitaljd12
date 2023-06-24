package id.co.indivara.jdt12.hospitalindivara.repo;

import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

}
