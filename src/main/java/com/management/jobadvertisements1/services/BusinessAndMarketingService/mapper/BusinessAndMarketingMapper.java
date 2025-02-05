package com.management.jobadvertisements1.services.BusinessAndMarketingService.mapper;

import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingCreateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingUpdateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.response.BusinessAndMarketingResponseDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.entity.BusinessAndMarketing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BusinessAndMarketingMapper {

    BusinessAndMarketingResponseDto toBusinessAndMarketingResponseDto(
            BusinessAndMarketing businessAndMarketing);

    BusinessAndMarketing toBusinessAndMarketing(
            BusinessAndMarketingCreateRequestDto businessAndMarketingCreateRequestDto);

    BusinessAndMarketing toBusinessAndMarketing(
            @MappingTarget BusinessAndMarketing businessAndMarketing,
            BusinessAndMarketingUpdateRequestDto businessAndMarketingUpdateRequestDto);

}
