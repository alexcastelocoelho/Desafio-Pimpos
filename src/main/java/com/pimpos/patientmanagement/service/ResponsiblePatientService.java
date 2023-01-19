package com.pimpos.patientmanagement.service;

import com.pimpos.patientmanagement.model.PatientModel;
import com.pimpos.patientmanagement.model.ResponsiblePatientModel;
import com.pimpos.patientmanagement.repository.ResponsiblePatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResponsiblePatientService {
    final ResponsiblePatientRepository responsiblePatientRepository;

    public ResponsiblePatientService(ResponsiblePatientRepository responsiblePatientRepository) {
        this.responsiblePatientRepository = responsiblePatientRepository;
    }

    public ResponsiblePatientModel save(ResponsiblePatientModel responsiblePatientModel) {
        return responsiblePatientRepository.save(responsiblePatientModel);
    }

    public boolean existsByCpf(String cpf) {
        return responsiblePatientRepository.existsByCpf(cpf);
    }

    public Page<ResponsiblePatientModel> findAll(Pageable pageable) {
        return responsiblePatientRepository.findAll(pageable);
    }

    public Optional<ResponsiblePatientModel> findById(UUID id) {
        return responsiblePatientRepository.findById(id);
    }

    public void delete(ResponsiblePatientModel responsiblePatientModel) {
        responsiblePatientRepository.delete(responsiblePatientModel);
    }
}
