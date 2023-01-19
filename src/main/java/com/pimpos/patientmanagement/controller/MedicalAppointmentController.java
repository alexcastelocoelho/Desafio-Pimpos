package com.pimpos.patientmanagement.controller;

import com.pimpos.patientmanagement.dto.DoctorDto;
import com.pimpos.patientmanagement.dto.MedicalAppointmentDto;
import com.pimpos.patientmanagement.model.DoctorModel;
import com.pimpos.patientmanagement.model.MedicalAppointmentModel;
import com.pimpos.patientmanagement.service.MedicalAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/medicalappointment")
public class MedicalAppointmentController {

    final MedicalAppointmentService medicalAppointmentService;

    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService) {
        this.medicalAppointmentService = medicalAppointmentService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid MedicalAppointmentDto medicalAppointmentDto) {
        MedicalAppointmentModel medicalAppointmentModel = new MedicalAppointmentModel();
        BeanUtils.copyProperties(medicalAppointmentDto, medicalAppointmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalAppointmentService.save(medicalAppointmentModel));
    }

    @GetMapping
    public ResponseEntity<Page<MedicalAppointmentModel>> list(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listOne(@PathVariable(value = "id") UUID id) {
        Optional<MedicalAppointmentModel> medicalAppointmentModelOptional = medicalAppointmentService.findById(id);
        if (!medicalAppointmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MedicalAppointment not found");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<MedicalAppointmentModel> medicalAppointmentModelOptional = medicalAppointmentService.findById(id);
        if (!medicalAppointmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MedicalAppointment not found");
        }
        medicalAppointmentService.delete(medicalAppointmentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("MedicalAppointment deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid MedicalAppointmentDto medicalAppointmentDto) {
        Optional<MedicalAppointmentModel> medicalAppointmentModelOptional = medicalAppointmentService.findById(id);
        if (!medicalAppointmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MedicalAppointment not found");
        }
        var medicalAppointmentModel = new MedicalAppointmentModel();
        BeanUtils.copyProperties(medicalAppointmentDto, medicalAppointmentModel);
        medicalAppointmentModel.setId(medicalAppointmentModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentService.save(medicalAppointmentModel));
    }
}
