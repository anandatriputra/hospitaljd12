package id.co.indivara.jdt12.hospitalindivara.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.hospitalindivara.model.dto.FormAppointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Appointment;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Patient;
import id.co.indivara.jdt12.hospitalindivara.service.AppointmentService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    @Before("")
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
    }

    @Test
    public void testCreateAppointment() throws Exception {
        // Mock data
        FormAppointment formAppointment = new FormAppointment();
        formAppointment.setPatientId(1);
        formAppointment.setSpecialistName("Specialist");
        formAppointment.setComplaint("Complaint");

        Appointment appointment = new Appointment();
        appointment.setId(1);
        appointment.setPatient(new Patient());
        appointment.setDoctor(new Doctor());
        appointment.setComplaint("Complaint");
        appointment.setRegisterStatus(false);


        // Mock service response
        Mockito.when(appointmentService.createAppointment(Mockito.any(FormAppointment.class)))
                .thenReturn(appointment);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/appointment/createAppointment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(formAppointment)))
                .andExpect(status().isCreated());
    }
}