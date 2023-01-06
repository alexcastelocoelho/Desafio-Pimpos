package com.pimpos.patientmanagement.repository;

import com.pimpos.patientmanagement.model.PatientModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, UUID> {

    boolean existsByCpf(String cpf);
}
