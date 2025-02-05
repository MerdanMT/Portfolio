package com.management.jobadvertisements1.services.HomeAndLivingService.mapper;

import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingCreateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingUpdateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.response.HomeAndLivingResponse;
import com.management.jobadvertisements1.services.HomeAndLivingService.entity.HomeAndLiving;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HomeAndLivingMapper {

    HomeAndLivingResponse toHomeAndLivingResponse(HomeAndLiving homeAndLiving);
    HomeAndLiving toHomeAndLiving(HomeAndLivingCreateRequest homeAndLivingCreateRequest);
    HomeAndLiving toHomeAndLiving(
            @MappingTarget HomeAndLiving homeAndLiving,
            HomeAndLivingUpdateRequest homeAndLivingUpdateRequest);
}
