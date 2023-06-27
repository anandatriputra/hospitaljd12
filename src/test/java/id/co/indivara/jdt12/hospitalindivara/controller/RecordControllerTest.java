package id.co.indivara.jdt12.hospitalindivara.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.hospitalindivara.model.dto.GetAllRecordData;
import id.co.indivara.jdt12.hospitalindivara.service.RecordService;
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

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RecordControllerTest {


        @Autowired
        private MockMvc mockMvc;

        @Mock
        private RecordService recordService;

        @InjectMocks
        private RecordController recordController;


        @Test
    public void getAllRecordData() throws Exception {

        // Mock data
        List<GetAllRecordData> medicalRecords = recordService.getAllRecordData();


        // Mock service response
        Mockito.when(recordService.getAllRecordData())
                .thenReturn(medicalRecords);

        // Perform the Get request
        mockMvc.perform(MockMvcRequestBuilders.get("/record/getAllRecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(medicalRecords)))
                .andExpect(status().isOk());
    }
}

