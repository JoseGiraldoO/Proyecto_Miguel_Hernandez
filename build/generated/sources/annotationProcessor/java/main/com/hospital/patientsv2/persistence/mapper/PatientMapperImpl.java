package com.hospital.patientsv2.persistence.mapper;

import com.hospital.patientsv2.domain.PatientDto;
import com.hospital.patientsv2.persistence.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T22:33:28-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public PatientDto toPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        if ( patient.getPatientId() != null ) {
            patientDto.setPatientIdDto( patient.getPatientId() );
        }
        patientDto.setFirstNameDto( patient.getFirstName() );
        patientDto.setLastNameDto( patient.getLastName() );
        patientDto.setAdressDto( patient.getAdress() );
        if ( patient.getHospitalId() != null ) {
            patientDto.setHospitalIdDto( patient.getHospitalId() );
        }
        patientDto.setCityDto( patient.getCity() );
        patientDto.setHospitalDto( hospitalMapper.toHospitalDto( patient.getHospital() ) );

        return patientDto;
    }

    @Override
    public List<PatientDto> toPatientDto(List<Patient> patients) {
        if ( patients == null ) {
            return null;
        }

        List<PatientDto> list = new ArrayList<PatientDto>( patients.size() );
        for ( Patient patient : patients ) {
            list.add( toPatientDto( patient ) );
        }

        return list;
    }

    @Override
    public Patient toPatient(PatientDto patientDto) {
        if ( patientDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientId( patientDto.getPatientIdDto() );
        patient.setFirstName( patientDto.getFirstNameDto() );
        patient.setLastName( patientDto.getLastNameDto() );
        patient.setAdress( patientDto.getAdressDto() );
        patient.setHospitalId( patientDto.getHospitalIdDto() );
        patient.setCity( patientDto.getCityDto() );
        patient.setHospital( hospitalMapper.toHospital( patientDto.getHospitalDto() ) );

        return patient;
    }
}
