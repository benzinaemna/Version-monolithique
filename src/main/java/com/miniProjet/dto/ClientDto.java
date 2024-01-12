package com.miniProjet.dto;

import lombok.*;

import java.util.UUID;

@Data
public class ClientDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String numTel;
    private String cin;
    private String email;
    private String adresse;

    public ClientDto() {
    }

    public ClientDto(UUID id, String firstName, String lastName, String numTel, String cin, String email, String adresse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numTel = numTel;
        this.cin = cin;
        this.email = email;
        this.adresse = adresse;
    }

    public ClientDto(UUID id, String firstName, String lastName, String numTel, String cin, String email, String adresse, UUID typeTierId, String typeTierLibelle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numTel = numTel;
        this.cin = cin;
        this.email = email;
        this.adresse = adresse;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
