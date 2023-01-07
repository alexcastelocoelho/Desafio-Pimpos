package com.pimpos.patientmanagement.service;

import com.pimpos.patientmanagement.model.PatientModel;
import com.pimpos.patientmanagement.model.ResponsiblePatientModel;
import com.pimpos.patientmanagement.repository.ResponsiblePatientRepository;
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

    public List<ResponsiblePatientModel> findAll() {
        return responsiblePatientRepository.findAll();
    }

    public Optional<ResponsiblePatientModel> findById(UUID id) {
        return responsiblePatientRepository.findById(id);
    }

    public void delete(ResponsiblePatientModel responsiblePatientModel) {
        responsiblePatientRepository.delete(responsiblePatientModel);
    }
}
