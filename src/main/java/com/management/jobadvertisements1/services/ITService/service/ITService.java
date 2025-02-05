package com.management.jobadvertisements1.services.ITService.service;

import com.management.jobadvertisements1.services.ITService.dto.request.ITCreateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.request.ITUpdateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.response.ITResponseDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;

import java.util.List;

public interface ITService {

    void addIT(ITCreateRequestDto itCreateRequestDto);

    void updateIT(Long id, ITUpdateRequestDto itUpdateRequestDto);

    void deleteIT(Long id, ITResponseDto itResponseDto);

    List<ITResponseDto> getAllIT();

    ITResponseDto getITById(Long id);

    ITResponseDto getITByUserId(Long fkUserId);

    List<UserResponseDto> getAllUserByITName(String itName);

    List<UserResponseDto> getAllUserByITNameAndRegion(String itName, String region);

}
