package id.co.indivara.jdt12.hospitalindivara.service;

import id.co.indivara.jdt12.hospitalindivara.model.dto.FormAppointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;

import java.util.List;

public interface AppointmentService {
    FormAppointment createAppointment (FormAppointment formAppointment);

}
