package com.hospital.patientsv2.persistence.mapper;


import com.hospital.patientsv2.domain.HospitalDto;
import com.hospital.patientsv2.persistence.entity.Hospital;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HospitalMapper {

    @Mappings({
            @Mapping(source = "hospitalId", target = "hospitalIdDto"),
            @Mapping(source = "hospital", target = "hospitalDto"),

    })
    HospitalDto toHospitalDto(Hospital hospital);

    List<HospitalDto> toHospitalDto(List<Hospital> hospitals);

    @InheritInverseConfiguration
    //Se excluye debido a que no lo creamos en hospitall
    @Mapping(target = "patients", ignore = true)
    Hospital toHospital(HospitalDto hospitalDto);

}
