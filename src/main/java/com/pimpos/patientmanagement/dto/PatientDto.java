package com.pimpos.patientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class PatientDto {
    @NotBlank(message = "enter your name")
    @Size(min = 3, max = 40, message = "your name must have at least three letters")
    private String name;
    @NotBlank(message = "enter your age")
    private String age;
    @NotBlank
    @Size(min = 14, max = 14)
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "use format xxx.xxx.xxx-xx")
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "enter your birthdate")
    private LocalDate birthdate;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
