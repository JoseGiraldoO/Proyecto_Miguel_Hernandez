package com.hospital.patientsv2.persistence.mapper;

import com.hospital.patientsv2.domain.PatientDto;
import com.hospital.patientsv2.persistence.entity.Patient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {HospitalMapper.class})
public interface PatientMapper {

    @Mappings({
            @Mapping(source = "patientId", target = "patientIdDto"),
            @Mapping(source = "firstName", target = "firstNameDto"),
            @Mapping(source = "lastName", target = "lastNameDto"),
            @Mapping(source = "adress", target = "adressDto"),
            @Mapping(source = "hospitalId", target = "hospitalIdDto"),
            @Mapping(source = "city", target = "cityDto"),
            @Mapping(source = "hospital", target = "hospitalDto")
    })
    PatientDto toPatientDto(Patient patient);

    List<PatientDto> toPatientDto(List<Patient> patients);


    @InheritInverseConfiguration
    Patient toPatient(PatientDto patientDto);

}
