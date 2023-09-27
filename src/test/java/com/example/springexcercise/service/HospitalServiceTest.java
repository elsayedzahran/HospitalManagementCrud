package com.example.springexcercise.service;


import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.servicesimpl.HospitalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class HospitalServiceTest {
    @Mock
    private HospitalRepo hospitalRepo;
    @Mock
    private HospitalMapper hospitalMapper;
    @InjectMocks
    private HospitalServiceImpl hospitalService;
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
        List<Hospital> hospitals= List.of(new Hospital(), new Hospital(), new Hospital());
        when(hospitalRepo.findAll()).thenReturn(hospitals);

        // when
        List<HospitalModel> hospitalModels = hospitalService.getAllHospitals();
        // then
        assertThat(hospitalModels.size()).isEqualTo(3);
    }
    @Test
    void getByIdTest(){
        // given
        int hospitalId = 1;
        Hospital hospital = new Hospital();
        HospitalModel hospitalModel = new HospitalModel();
        when(hospitalRepo.findById(hospitalId)).thenReturn(Optional.of(hospital));
        when(hospitalMapper.toModel(hospital)).thenReturn(hospitalModel);
        // when
        HospitalModel result = hospitalService.getHospitalById(1);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(hospitalModel);
    }
    @Test
    void addHospitalTest(){
        // given
        HospitalModel hospitalModel = new HospitalModel();
        hospitalModel.setAddress("address");
        hospitalModel.setName("my hospital");

        Hospital hospital = new Hospital();
        hospital.setAddress("address");
        hospital.setName("my hospital");
        hospital.setId(1);
        when(hospitalMapper.toEntity(hospitalModel)).thenReturn(hospital);
        when(hospitalRepo.save(hospital)).thenReturn(hospital);

        // when
        HospitalModel result = hospitalService.addHospital(hospitalModel);

        // then
        assertThat(result.getName()).isEqualTo("my hospital");
    }

    @Test
    public void testUpdateHospital() {
        // Given
        int hospitalId = 1;
        HospitalModel hospitalModel = new HospitalModel();
        hospitalModel.setName("Updated Name");
        hospitalModel.setAddress("Updated Address");
        Hospital existingHospital = new Hospital();
        existingHospital.setId(hospitalId);
        existingHospital.setName("Original Name");
        existingHospital.setAddress("Original Address");

        when(hospitalRepo.findById(hospitalId)).thenReturn(Optional.of(existingHospital));

        // When
        HospitalModel updatedHospital = hospitalService.updateHospital(hospitalId, hospitalModel);

        // Then
        verify(hospitalRepo).findById(hospitalId);
        verify(hospitalRepo).save(existingHospital);
        assertThat(updatedHospital)
                .isNotNull()
                .extracting(HospitalModel::getName, HospitalModel::getAddress)
                .containsExactly(hospitalModel.getName(), hospitalModel.getAddress());
    }

    @Test
    void deleteHospitalTest(){
        // given
        int hospitalId = 1;
        Hospital hospital = new Hospital();
        hospital.setAddress("address");
        hospital.setName("my hospital");
        hospital.setId(1);
        when(hospitalRepo.findById(hospitalId)).thenReturn(Optional.of(hospital));
        doNothing().when(hospitalRepo).delete(hospital);

        // when
        Throwable throwable = catchThrowable(() -> hospitalService.deleteHospital(hospitalId));

        // then
        assertThat(throwable).doesNotThrowAnyException();

    }

}
