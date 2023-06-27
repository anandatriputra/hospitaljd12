package id.co.indivara.jdt12.hospitalindivara.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Doctor;
import id.co.indivara.jdt12.hospitalindivara.model.entity.Specialization;
import id.co.indivara.jdt12.hospitalindivara.repo.DoctorRepository;
import id.co.indivara.jdt12.hospitalindivara.repo.SpecializationRepository;
import id.co.indivara.jdt12.hospitalindivara.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DoctorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;

    @Autowired
    private SpecializationRepository specializationRepository;

    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
    }

    @Test
    public void testCreateDoctor() throws Exception {
        // Mock data
        Doctor doctor = new Doctor();
        Specialization specialization = new Specialization();
        specialization.setId(1);
        specialization.setSpecialistName("jantung");
        doctor.setId(1);
        doctor.setNameDoctor("aki");
        doctor.setAddress("jalan mulia");
        doctor.setNumberPhone("087666656");
        doctor.setDoctorReady(true);

        // Mock repository methods
        Mockito.when(doctorService.createDoctor(Mockito.any(Doctor.class)))
                .thenReturn(doctor);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/doctor/createdoctors/{specialistId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(doctor)))
               .andExpect(status().isCreated());
    }
}