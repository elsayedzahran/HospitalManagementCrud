package com.example.springexcercise.service;


import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.DrugModel;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.repository.DrugRepo;
import com.example.springexcercise.repository.PatientRepo;
import com.example.springexcercise.service.mappers.DrugMapper;
import com.example.springexcercise.service.mappers.PatientMapper;
import com.example.springexcercise.service.servicesimpl.DrugServiceImpl;
import com.example.springexcercise.service.servicesimpl.PatientServiceImpl;
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
class DrugServiceTest {
    @Mock
    private DrugRepo drugRepo;
    @Mock
    private DrugMapper drugMapper;
    @InjectMocks
    private DrugServiceImpl drugService;
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
        when(drugRepo.findAll()).thenReturn(List.of(new Drug(), new Drug()));

        // when
        List<Drug> result = drugService.getAllDrugs();

        // then
        assertThat(result).hasSize(2);
    }
    @Test
    void getByIdTest(){
        // given
        int drugId = 1;
        Drug drug = new Drug();
        when(drugRepo.findById(drugId)).thenReturn(Optional.of(drug));

        // when
        Drug result = drugService.getDrugById(drugId);

        // then
        assertThat(result).isNotNull();

    }
    @Test
    void addDrugTest(){
        // given
        DrugModel drugModel = new DrugModel();
        Drug drug = new Drug();
        when(drugMapper.toEntity(drugModel)).thenReturn(drug);
        when(drugRepo.save(drug)).thenReturn(drug);

        // when
        Drug result = drugService.addDrug(drugModel);

        // then
        assertThat(result).isNotNull();
    }
    @Test
    public void testUpdateDrug() {
        // Given
        int drugId = 1;
        DrugModel drugModel = new DrugModel();
        drugModel.setName("Updated Name");
        drugModel.setDescription("Updated Description");

        Drug existingDrug = new Drug();
        existingDrug.setId(drugId);
        existingDrug.setName("Original Name");
        existingDrug.setDescription("Original Description");

        when(drugRepo.findById(drugId)).thenReturn(Optional.of(existingDrug));

        // When
        Drug updatedDrug = drugService.updateDrug(drugId, drugModel);

        // Then
        verify(drugRepo).findById(drugId);
        verify(drugRepo).save(existingDrug);
        assertThat(updatedDrug)
                .isNotNull()
                .extracting(Drug::getName, Drug::getDescription)
                .containsExactly(drugModel.getName(), drugModel.getDescription());
    }
    @Test
    void deleteDrugTest(){
        // given
        int drugId = 1;
        Drug drug = new Drug();
        when(drugRepo.findById(drugId)).thenReturn(Optional.of(drug));
        doNothing().when(drugRepo).delete(drug);

        // when
        Throwable throwable = catchThrowable(() -> drugService.deleteDrug(drugId));

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

}
