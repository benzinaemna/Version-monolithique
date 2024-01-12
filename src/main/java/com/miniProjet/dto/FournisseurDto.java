package com.miniProjet.dto;

import lombok.*;

import java.util.UUID;

@Data
public class FournisseurDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String numTel;
    private String mf;
    private String email;
    private String adresse;


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

    public String getMf() {
        return mf;
    }

    public void setMf(String mf) {
        this.mf = mf;
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


    public FournisseurDto() {
    }

    public FournisseurDto(UUID id, String firstName, String lastName, String numTel, String mf, String email, String adresse, UUID typeTierId, String typeTierLibelle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numTel = numTel;
        this.mf = mf;
        this.email = email;
        this.adresse = adresse;

    }
}
