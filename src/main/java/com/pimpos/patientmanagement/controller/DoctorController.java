package com.pimpos.patientmanagement.controller;

import com.pimpos.patientmanagement.dto.DoctorDto;
import com.pimpos.patientmanagement.dto.PatientDto;
import com.pimpos.patientmanagement.model.DoctorModel;
import com.pimpos.patientmanagement.model.PatientModel;
import com.pimpos.patientmanagement.model.ResponsiblePatientModel;
import com.pimpos.patientmanagement.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid DoctorDto doctorDto) {
        if(doctorService.existsByCpf(doctorDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: cpf already exists");
        }
        DoctorModel doctorModel = new DoctorModel();
        BeanUtils.copyProperties(doctorDto, doctorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.save(doctorModel));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorModel>> list(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listOne(@PathVariable(value = "id") UUID id) {
        Optional<DoctorModel> doctorModelOptional = doctorService.findById(id);
        if (!doctorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(doctorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<DoctorModel> doctorModelOptionalModelOptional = doctorService.findById(id);
        if (!doctorModelOptionalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        doctorService.delete(doctorModelOptionalModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Doctor deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid DoctorDto doctorDto) {
        Optional<DoctorModel> doctorModelOptionalModelOptional = doctorService.findById(id);
        if (!doctorModelOptionalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        var doctorModel = new DoctorModel();
        BeanUtils.copyProperties(doctorDto, doctorModel);
        doctorModel.setId(doctorModelOptionalModelOptional.get().getId());
        doctorModel.setCpf(doctorModelOptionalModelOptional.get().getCpf());
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.save(doctorModel));
    }

}
