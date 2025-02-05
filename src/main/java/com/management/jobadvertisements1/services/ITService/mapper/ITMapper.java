package com.management.jobadvertisements1.services.ITService.mapper;

import com.management.jobadvertisements1.services.ITService.dto.request.ITCreateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.request.ITUpdateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.response.ITResponseDto;
import com.management.jobadvertisements1.services.ITService.entity.IT;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITMapper {

    ITResponseDto toITResponse(IT it);
    IT toIT(ITCreateRequestDto itCreateRequestDto);
    IT toIT(@MappingTarget IT it, ITUpdateRequestDto itUpdateRequestDto);
}
