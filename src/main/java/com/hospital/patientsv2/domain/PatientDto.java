package com.hospital.patientsv2.domain;

public class PatientDto {

    private int patientIdDto;
    private String firstNameDto;

    private String lastNameDto;
    private String adressDto;
    private int hospitalIdDto;
    private String cityDto;
    private HospitalDto hospitalDto;

    public int getPatientIdDto() {
        return patientIdDto;
    }

    public void setPatientIdDto(int patientIdDto) {
        this.patientIdDto = patientIdDto;
    }

    public String getFirstNameDto() {
        return firstNameDto;
    }

    public void setFirstNameDto(String firstNameDto) {
        this.firstNameDto = firstNameDto;
    }

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getAdressDto() {
        return adressDto;
    }

    public void setAdressDto(String adressDto) {
        this.adressDto = adressDto;
    }

    public int getHospitalIdDto() {
        return hospitalIdDto;
    }

    public void setHospitalIdDto(int hospitalIdDto) {
        this.hospitalIdDto = hospitalIdDto;
    }

    public String getCityDto() {
        return cityDto;
    }

    public void setCityDto(String cityDto) {
        this.cityDto = cityDto;
    }

    public HospitalDto getHospitalDto() {
        return hospitalDto;
    }

    public void setHospitalDto(HospitalDto hospitalDto) {
        this.hospitalDto = hospitalDto;
    }
}
