package id.co.indivara.jdt12.hospitalindivara.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import id.co.indivara.jdt12.hospitalindivara.repo.SpecializationRepository;
import id.co.indivara.jdt12.hospitalindivara.service.DoctorService;
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

import java.util.Optional;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SpecializationRepository specializationRepository;

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;


    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
    }

    @Test
    public void testCreateDoctor() throws Exception {
        // Mock data
        Doctor doctor = new Doctor();
        doctor.setNameDoctor("loki");
        doctor.setSpecialization(new Specialization());

        Specialization specialization = new Specialization();
        specialization.setId(1);

        // Mock repository methods
        Mockito.when(specializationRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(specialization));
        Mockito.when(doctorService.createDoctor(Mockito.any(Doctor.class))).thenReturn(doctor);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/doctor/createdoctors/{specialistId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(doctor)))
                .andExpect(status().isCreated());
    }
}