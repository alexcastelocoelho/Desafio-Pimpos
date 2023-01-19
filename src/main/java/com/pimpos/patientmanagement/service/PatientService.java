package com.pimpos.patientmanagement.service;

import com.pimpos.patientmanagement.model.PatientModel;
import com.pimpos.patientmanagement.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<PatientModel> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
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
