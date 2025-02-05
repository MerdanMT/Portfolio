package com.management.jobadvertisements1.services.MedicalService.service;

import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalCreateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalUpdateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.response.MedicalResponseDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;

import java.util.List;

public interface MedicalService {

    void addMedical(MedicalCreateRequestDto medicalCreateRequestDto);

    void updateMedical(Long id, MedicalUpdateRequestDto medicalUpdateRequestDto);

    void deleteMedical(Long id, MedicalResponseDto medicalResponseDto);

    List<MedicalResponseDto> getAllMedicals();

    MedicalResponseDto getMedicalById(Long id);

    MedicalResponseDto getMedicalByUserId(Long fkUserId);

    List<UserResponseDto> getAllUserByMedicalName(String medicalName);

    List<UserResponseDto> getAllUserByMedicalNameAndRegion(String medicalName,String region);
}
