package com.pimpos.patientmanagement.controller;

import com.pimpos.patientmanagement.dto.PatientDto;
import com.pimpos.patientmanagement.dto.ResponsiblePatientDto;
import com.pimpos.patientmanagement.model.PatientModel;
import com.pimpos.patientmanagement.model.ResponsiblePatientModel;
import com.pimpos.patientmanagement.service.ResponsiblePatientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/responsibles")
public class ResponsiblePatientController {
    final ResponsiblePatientService responsiblePatientService;

    public ResponsiblePatientController(ResponsiblePatientService responsiblePatientService) {
        this.responsiblePatientService = responsiblePatientService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid ResponsiblePatientDto responsiblePatientDro ) {
        if(responsiblePatientService.existsByCpf(responsiblePatientDro.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: cpf is already in use");
        }
        ResponsiblePatientModel responsiblePatientModel = new ResponsiblePatientModel();
        BeanUtils.copyProperties(responsiblePatientDro, responsiblePatientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsiblePatientService.save(responsiblePatientModel));
    }

    @GetMapping
    public ResponseEntity<List<ResponsiblePatientModel>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(responsiblePatientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listOne(@PathVariable(value = "id") UUID id) {
        Optional<ResponsiblePatientModel> responsiblePatientModelOptional = responsiblePatientService.findById(id);
        if (!responsiblePatientModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsible not found");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(responsiblePatientModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<ResponsiblePatientModel> responsiblePatientModelOptional = responsiblePatientService.findById(id);
        if (!responsiblePatientModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsible not found");
        }
        responsiblePatientService.delete(responsiblePatientModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Responsible deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid ResponsiblePatientDto responsiblePatientDro) {
        Optional<ResponsiblePatientModel> responsiblePatientModelOptional = responsiblePatientService.findById(id);
        if (!responsiblePatientModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsible not found");
        }
        var ResponsiblePatientModel = new ResponsiblePatientModel();
        BeanUtils.copyProperties(responsiblePatientDro, ResponsiblePatientModel);
        ResponsiblePatientModel.setId(responsiblePatientModelOptional.get().getId());
        ResponsiblePatientModel.setCpf(responsiblePatientModelOptional.get().getCpf());
        return ResponseEntity.status(HttpStatus.OK).body(responsiblePatientService.save(ResponsiblePatientModel));
    }

}
