package id.co.indivara.jdt12.hospitalindivara.controller;
import id.co.indivara.jdt12.hospitalindivara.controller.AppointmentController;
import id.co.indivara.jdt12.hospitalindivara.model.dto.FormAppointment;
import id.co.indivara.jdt12.hospitalindivara.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAppointment_ReturnsCreatedStatus() {
        // Arrange
        FormAppointment formAppointment = new FormAppointment();
        // Set up any necessary fields in formAppointment

        FormAppointment createdAppointment = new FormAppointment();
        // Set up any expected fields in createdAppointment

        when(appointmentService.createAppointment(formAppointment)).thenReturn(createdAppointment);

        // Act
        ResponseEntity<FormAppointment> response = appointmentController.createAppointment(formAppointment);

        // Assert
        verify(appointmentService, times(1)).createAppointment(formAppointment);
        verifyNoMoreInteractions(appointmentService);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdAppointment, response.getBody());
    }
}