package com.management.jobadvertisements1.services.HomeAndLivingService.service;

import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingCreateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingUpdateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.response.HomeAndLivingResponse;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;

import java.util.List;

public interface HomeAndLivingService {

    void addHomeAndLiving(HomeAndLivingCreateRequest homeAndLivingCreateRequest);

    void updateHomeAndLiving(Long id, HomeAndLivingUpdateRequest homeAndLivingUpdateRequest);

    void deleteHomeAndLiving(Long id, HomeAndLivingResponse homeAndLivingResponse);

    List<HomeAndLivingResponse> getAllHomeAndLiving();

    HomeAndLivingResponse getHomeAndLivingById(Long id);

    HomeAndLivingResponse getHomeAndLivingByUserId(Long fkUserId);

    List<UserResponseDto> getAllUserByHomeAndLivingName(String homeAndLivingName);

    List<UserResponseDto> getAllUserByHomeAndLivingNameAndRegion(String homeAndLivingName, String region);
}
