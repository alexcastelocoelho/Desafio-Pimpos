package com.pimpos.patientmanagement.repository;

import com.pimpos.patientmanagement.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {
    boolean existsByCpf(String cpf);
}
