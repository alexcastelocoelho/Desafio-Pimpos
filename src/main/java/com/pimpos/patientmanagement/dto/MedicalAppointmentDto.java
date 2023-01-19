package com.pimpos.patientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pimpos.patientmanagement.model.DoctorModel;
import com.pimpos.patientmanagement.model.PatientModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedicalAppointmentDto {
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate consultationDate;
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "inform the appointment time")
    private LocalTime hour;
    @NotNull(message = "inform the patient of the appointment")
    private PatientModel patient;
    @NotNull(message = "inform the doctor of the appointment")
    private DoctorModel doctor;
    @NotBlank
    private String status;

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
