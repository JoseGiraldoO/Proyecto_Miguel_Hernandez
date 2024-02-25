package com.hospital.patientsv2.persistence.mapper;

import com.hospital.patientsv2.domain.HospitalDto;
import com.hospital.patientsv2.persistence.entity.Hospital;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T22:33:28-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class HospitalMapperImpl implements HospitalMapper {

    @Override
    public HospitalDto toHospitalDto(Hospital hospital) {
        if ( hospital == null ) {
            return null;
        }

        HospitalDto hospitalDto = new HospitalDto();

        if ( hospital.getHospitalId() != null ) {
            hospitalDto.setHospitalIdDto( hospital.getHospitalId() );
        }
        hospitalDto.setHospitalDto( hospital.getHospital() );

        return hospitalDto;
    }

    @Override
    public List<HospitalDto> toHospitalDto(List<Hospital> hospitals) {
        if ( hospitals == null ) {
            return null;
        }

        List<HospitalDto> list = new ArrayList<HospitalDto>( hospitals.size() );
        for ( Hospital hospital : hospitals ) {
            list.add( toHospitalDto( hospital ) );
        }

        return list;
    }

    @Override
    public Hospital toHospital(HospitalDto hospitalDto) {
        if ( hospitalDto == null ) {
            return null;
        }

        Hospital hospital = new Hospital();

        hospital.setHospitalId( hospitalDto.getHospitalIdDto() );
        hospital.setHospital( hospitalDto.getHospitalDto() );

        return hospital;
    }
}
