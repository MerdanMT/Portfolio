package com.management.jobadvertisements1.services.MedicalService.mapper;

import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalCreateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalUpdateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.response.MedicalResponseDto;
import com.management.jobadvertisements1.services.MedicalService.entity.Medical;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MedicalMapper {

    MedicalResponseDto toMedicalResponse(Medical medical);
    Medical toMedical(MedicalCreateRequestDto medicalCreateRequestDto);
    Medical toMedical(@MappingTarget Medical medical, MedicalUpdateRequestDto medicalUpdateRequestDto);

}
