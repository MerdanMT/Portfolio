package com.management.jobadvertisements1.services.MedicalService.controller;

import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalCreateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalUpdateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.response.MedicalResponseDto;
import com.management.jobadvertisements1.services.MedicalService.service.MedicalService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicals")
@RequiredArgsConstructor
public class MedicalController {

    private final MedicalService medicalService;

    @PostMapping
    public void addMedical(@RequestBody MedicalCreateRequestDto medicalCreateRequestDto){
        medicalService.addMedical(medicalCreateRequestDto);
    }

    @PutMapping("/{id}")
    public void updateMedical(@PathVariable Long id,
                              @RequestBody MedicalUpdateRequestDto medicalUpdateRequestDto){
        medicalService.updateMedical(id,medicalUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMedical(@PathVariable Long id, @RequestBody MedicalResponseDto medicalResponseDto){
        medicalService.deleteMedical(id,medicalResponseDto);
    }

    @GetMapping
    public List<MedicalResponseDto> getAllMedicals(){
        return medicalService.getAllMedicals();
    }

    @GetMapping("/{id}")
    public MedicalResponseDto getMedicalById(@PathVariable Long id){
        return medicalService.getMedicalById(id);
    }

    @GetMapping("/get-medical-by-user-id/{fkUserId}")
    public MedicalResponseDto getMedicalByUserId(@PathVariable Long fkUserId){
        return medicalService.getMedicalByUserId(fkUserId);
    }

    @GetMapping("/get-all-users-by-service-name/{medicalName}")
    public List<UserResponseDto> getAllUserByMedicalName(@PathVariable String medicalName){
        return  medicalService.getAllUserByMedicalName(medicalName);
    }

    @GetMapping("/get-all-users-by-service-name-and-region/{medicalName}{region}")
    public List<UserResponseDto> getAllUserByMedicalNameAndRegion(@PathVariable String medicalName,
                                                                  @PathVariable String region){
        return medicalService.getAllUserByMedicalNameAndRegion(medicalName,region);
    }

}
