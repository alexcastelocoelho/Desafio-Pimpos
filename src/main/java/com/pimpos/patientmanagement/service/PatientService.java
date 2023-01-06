package com.pimpos.patientmanagement.service;

import com.pimpos.patientmanagement.model.PatientModel;
import com.pimpos.patientmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientModel save(PatientModel patientModel) {
        return patientRepository.save(patientModel);
    }

    public List<PatientModel> findAll() {
        return patientRepository.findAll();
    }

    public Optional<PatientModel> findById(UUID id) {
        return patientRepository.findById(id);
    }

    public void delete(PatientModel patientModel) {
        patientRepository.delete(patientModel);
    }

    public boolean existsByCpf(String cpf) {
        return patientRepository.existsByCpf(cpf);

    }
}
