package com.example.springexcercise.service;


import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.repository.PatientRepo;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.mappers.PatientMapper;
import com.example.springexcercise.service.servicesimpl.HospitalServiceImpl;
import com.example.springexcercise.service.servicesimpl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@SpringBootTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PatientServiceTest {
    @Mock
    private PatientRepo patientRepo;
    @Mock
    private PatientMapper patientMapper;
    @InjectMocks
    private PatientServiceImpl patientService;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void test(){

    }
    @Test
    void getAllTest(){
        // given
        when(patientRepo.findAll()).thenReturn(List.of(new Patient(), new Patient()));
        // when
        List<Patient> result = patientService.getAllPatients();

        // then
        assertThat(result).hasSize(2);
    }
    @Test
    void getByIdTest(){
        // given
        int patientId = 1;
        Patient patient = new Patient();
        when(patientRepo.findById(patientId)).thenReturn(Optional.of(patient));
        // when
        Patient result = patientService.getPatientById(patientId);
        // then
        assertThat(result).isNotNull();

    }
    @Test
    void addPatientTest(){
        // given
        PatientModel patientModel = new PatientModel();
        Patient patientEntity = new Patient();
        when(patientMapper.toEntity(patientModel)).thenReturn(patientEntity);
        when(patientRepo.save(patientEntity)).thenReturn(patientEntity);

        // when
        Patient result = patientService.addPatient(patientModel);

        // then
        assertThat(result).isNotNull();
    }
    @Test
    public void testUpdatePatient() {
        // Given
        int patientId = 1;
        PatientModel patientModel = new PatientModel();
        patientModel.setName("Updated Name");
        Patient existingPatient = new Patient();
        existingPatient.setId(patientId);
        existingPatient.setName("Original Name");
        when(patientRepo.findById(patientId)).thenReturn(Optional.of(existingPatient));

        // When
        Patient updatedPatient = patientService.updatePatient(patientId, patientModel);

        // Then
        verify(patientRepo).findById(patientId);
        verify(patientRepo).save(existingPatient);
        assertThat(updatedPatient)
                .isNotNull()
                .extracting(Patient::getName)
                .isEqualTo(patientModel.getName());
    }
    @Test
    void deletePatientTest(){
        // given
        int patientId = 1;
        Patient patientEntity = new Patient();
        when(patientRepo.findById(patientId)).thenReturn(Optional.of(patientEntity));
        doNothing().when(patientRepo).delete(patientEntity);

        // when
        Throwable throwable = catchThrowable(() -> patientService.deletePatient(patientId));

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

}
