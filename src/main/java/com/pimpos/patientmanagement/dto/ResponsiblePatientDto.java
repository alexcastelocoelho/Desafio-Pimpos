package com.pimpos.patientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ResponsiblePatientDto {
    @NotBlank(message = "enter your name")
    @Size(min = 3, max = 40, message = "your name must have at least three letters")
    private String name;
    @NotBlank
    @Size(min = 14, max = 14)
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "use format xxx.xxx.xxx-xx")
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "enter your birthdate")
    private LocalDate birthdate;
    @NotBlank(message = "inform the responsible relationship with the patient" )
    private String kinship;
    @NotBlank(message = "enter your contact")
    @Pattern(regexp ="^\\(?\\d{2}\\)?[\\s-]?[\\s9]?\\d{4}-?\\d{4}$", message = "enter the ddd plus the number(only numbers)")
    private String contact;
    @NotBlank(message = "inform your address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
