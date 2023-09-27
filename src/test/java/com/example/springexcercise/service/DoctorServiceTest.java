package com.example.springexcercise.service;


import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.repository.DoctorRepo;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.service.mappers.DoctorMapper;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.servicesimpl.DoctorServiceImpl;
import com.example.springexcercise.service.servicesimpl.HospitalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@SpringBootTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DoctorServiceTest {
    @Mock
    private DoctorRepo doctorRepo;
    @Mock
    private DoctorMapper doctorMapper;
    @InjectMocks
    private DoctorServiceImpl doctorService;
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
        List<Doctor> doctors= List.of(new Doctor(), new Doctor(), new Doctor());
        when(doctorRepo.findAll()).thenReturn(doctors);

        // when
        List<DoctorModel> result = doctorService.getAllDoctors();
        // then
        assertThat(result).hasSize(3);
    }
    @Test
    void getByIdTest(){
        // given
        int doctorId = 1;
        Doctor doctor = new Doctor();
        DoctorModel doctorModel = new DoctorModel();
        when(doctorRepo.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(doctorMapper.toModel(doctor)).thenReturn(doctorModel);

        // when
        DoctorModel result = doctorService.getDoctorById(1);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(doctorModel);
    }
    @Test
    void addDoctorTest(){
        // given
        DoctorModel doctorModel = new DoctorModel();
        doctorModel.setName("my hospital");

        Doctor doctor = new Doctor();
        doctor.setName("my hospital");
        doctor.setId(1);
        when(doctorMapper.toEntity(doctorModel)).thenReturn(doctor);
        when(doctorRepo.save(doctor)).thenReturn(doctor);

        // when
        DoctorModel result = doctorService.addDoctor(doctorModel);

        // then
        assertThat(result.getName()).isEqualTo("my hospital");
    }

//    @Test
//    public void testUpdateDoctor() {
//        // Given
//        int doctorId = 1;
//        DoctorModel doctorModel = new DoctorModel();
//        doctorModel.setName("Updated Name");
//        Doctor existingDoctor = new Doctor();
//        existingDoctor.setId(doctorId);
//        existingDoctor.setName("Original Name");
//        when(doctorRepo.findById(doctorId)).thenReturn(Optional.of(existingDoctor));
//        when(doctorMapper.toModel(existingDoctor)).thenReturn(doctorModel);
//        // When
//        DoctorModel updatedDoctor = doctorService.updateDoctor(doctorId, doctorModel);
//
//        // Then
//        verify(doctorRepo).findById(doctorId);
//        verify(doctorRepo).save(existingDoctor);
//
//        assertThat(updatedDoctor)
//                .isNotNull()
//                .extracting(DoctorModel::getName)
//                .isEqualTo(doctorModel.getName());
//    }

    @Test
    void deleteDoctorTest(){
        // given
        int doctorId = 1;
        Doctor doctor = new Doctor();
        doctor.setName("my hospital");
        doctor.setId(1);
        when(doctorRepo.findById(doctorId)).thenReturn(Optional.of(doctor));
        doNothing().when(doctorRepo).delete(doctor);

        // when
        Throwable throwable = catchThrowable(() -> doctorService.deleteDoctor(doctorId));

        // then
        assertThat(throwable).doesNotThrowAnyException();

    }

}
