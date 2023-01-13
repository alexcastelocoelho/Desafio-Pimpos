package com.pimpos.patientmanagement.repository;

import com.pimpos.patientmanagement.model.MedicalAppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointmentModel, UUID> {
}
