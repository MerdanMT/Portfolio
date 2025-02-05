package com.management.jobadvertisements1.services.BusinessAndMarketingService.service;

import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingCreateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingUpdateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.response.BusinessAndMarketingResponseDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;

import java.util.List;

public interface BusinessAndMarketingService {

    void addBusinessAndMarketing(
            BusinessAndMarketingCreateRequestDto businessAndMarketingCreateRequestDto);

    void updateBusinessAndMarketing(
            Long id,BusinessAndMarketingUpdateRequestDto businessAndMarketingUpdateRequestDto);

    void deleteBusinessAndMarketing(Long id,
                                    BusinessAndMarketingResponseDto businessAndMarketingResponseDto);

    List<BusinessAndMarketingResponseDto> getAllBusinessAndMarketing();

    BusinessAndMarketingResponseDto getBusinessAndMarketingById(Long id);

    BusinessAndMarketingResponseDto getBusinessAndMarketingByUserId(Long fkUserId);

    List<UserResponseDto> getAllUserByBusinessAndMarketingName(String businessAndMarketingName);

    List<UserResponseDto> getAllUserByBusinessAndMarketingNameAndRegion(String businessAndMarketingName, String region);

}
