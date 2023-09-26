package com.example.springexcercise.repository;



import com.example.springexcercise.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepo extends JpaRepository<Drug, Integer> {
}
