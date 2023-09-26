package com.example.springexcercise.repository;



import com.example.springexcercise.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
    @Query(
            "SELECT case when count(h) > 0 then " +
                    "true else false end " +
                    "from Hospital h where h.name = ?1"
    )
    Boolean selectExistByHospitalName(String name);

}
