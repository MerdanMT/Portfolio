package com.management.jobadvertisements1.services.MedicalService.service.serviceImpl;

import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalCreateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.request.MedicalUpdateRequestDto;
import com.management.jobadvertisements1.services.MedicalService.dto.response.MedicalResponseDto;
import com.management.jobadvertisements1.services.MedicalService.entity.Medical;
import com.management.jobadvertisements1.services.MedicalService.mapper.MedicalMapper;
import com.management.jobadvertisements1.services.MedicalService.repository.MedicalRepository;
import com.management.jobadvertisements1.services.MedicalService.service.MedicalService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.mapper.UserMapper;
import com.management.jobadvertisements1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("medicalServiceImpl")
@RequiredArgsConstructor
public class ServiceImpl implements MedicalService {

    private final MedicalRepository medicalRepository;
    private final MedicalMapper medicalMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void addMedical(MedicalCreateRequestDto medicalCreateRequestDto) {

        medicalRepository.save(medicalMapper.toMedical(medicalCreateRequestDto));
    }

    @Override
    public void updateMedical(Long id, MedicalUpdateRequestDto medicalUpdateRequestDto) {

        Medical medical = medicalRepository.findById(id).orElseThrow();
        medicalRepository.save(medicalMapper.toMedical(medical, medicalUpdateRequestDto));
    }

    @Override
    public void deleteMedical(Long id, MedicalResponseDto medicalResponseDto) {

        medicalRepository.deleteById(id);
    }

    @Override
    public List<MedicalResponseDto> getAllMedicals() {

        List<Medical> medicals = medicalRepository.findAll();
        List<MedicalResponseDto> medicalResponseDtos = new ArrayList<>();
        for (Medical medical : medicals) {
            medicalResponseDtos.add(medicalMapper.toMedicalResponse(medical));
        }
        return medicalResponseDtos;
    }

    @Override
    public MedicalResponseDto getMedicalById(Long id) {

        return medicalMapper.toMedicalResponse(medicalRepository.findById(id).orElseThrow());
    }

    @Override
    public MedicalResponseDto getMedicalByUserId(Long fkUserId) {

        return medicalMapper.toMedicalResponse(medicalRepository.getAllByFkUserId(fkUserId));
    }

    @Override
    public List<UserResponseDto> getAllUserByMedicalName(String medicalName) {

        List<UserResponseDto> userList = new ArrayList<>();
        List<Medical> medicals = medicalRepository.getAllByNameLikeIgnoreCase(medicalName);
        for (Medical medical : medicals) {

            long a = medical.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList;

    }

    @Override
    public List<UserResponseDto> getAllUserByMedicalNameAndRegion(String medicalName, String region) {

        List<UserResponseDto> userList = new ArrayList<>();
        List<Medical> medicals = medicalRepository.getAllByNameLikeIgnoreCase(medicalName);
        for (Medical medical : medicals) {

            long a = medical.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList.stream().filter(reg->reg.getRegion().equals(region)).toList();
    }
}
