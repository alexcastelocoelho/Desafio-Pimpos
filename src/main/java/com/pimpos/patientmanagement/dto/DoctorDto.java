package com.pimpos.patientmanagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class DoctorDto {
    @NotBlank
    private String name;
    @NotBlank
    private String adviceNumber;
    @NotBlank
    @Size(min = 14, max = 14)
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")
    private String cpf;
    @NotBlank
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdviceNumber() {
        return adviceNumber;
    }

    public void setAdviceNumber(String adviceNumber) {
        this.adviceNumber = adviceNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
