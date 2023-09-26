package com.example.springexcercise.repository;

import com.example.springexcercise.entity.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class HospitalRepoTest {
    @Autowired
    private HospitalRepo hospitalRepo;

    @Test
    void tes1(){

    }
    @Test
    void testExistByHospitalNameReturnTrue(){
        // given
        Hospital hospital = new Hospital();
        hospital.setName("sa");
        hospital.setAddress("sa");
        hospitalRepo.save(hospital);

        // when
        boolean valid = hospitalRepo.selectExistByHospitalName("sa");

        //then
        assertThat(valid).isTrue();
    }
    @Test
    void testExistByHospitalNameReturnFalse(){
        // given
        Hospital hospital = new Hospital();
        hospital.setName("sa");
        hospital.setAddress("sa");
        hospitalRepo.save(hospital);

        // when
        boolean valid = hospitalRepo.selectExistByHospitalName("SA");

        //then
        assertThat(valid).isFalse();
    }
}
