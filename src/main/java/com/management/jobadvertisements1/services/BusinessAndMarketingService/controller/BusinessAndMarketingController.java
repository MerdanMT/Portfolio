package com.management.jobadvertisements1.services.BusinessAndMarketingService.controller;

import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingCreateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingUpdateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.response.BusinessAndMarketingResponseDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.service.BusinessAndMarketingService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/business_and_marketing")
@RequiredArgsConstructor
public class BusinessAndMarketingController {

    private final BusinessAndMarketingService businessAndMarketingService;

    @PostMapping
    public void addBusinessAndMarketing(
            @RequestBody BusinessAndMarketingCreateRequestDto businessAndMarketingCreateRequestDto)
    {

        businessAndMarketingService.addBusinessAndMarketing(businessAndMarketingCreateRequestDto);
    }

    @PutMapping("/{id}")
    public void updateBusinessAndMarketing(
            @PathVariable Long id,
            @RequestBody BusinessAndMarketingUpdateRequestDto businessAndMarketingUpdateRequestDto)
    {
        businessAndMarketingService.updateBusinessAndMarketing(id, businessAndMarketingUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBusinessAndMarketing(@PathVariable Long id,
                                           @RequestBody BusinessAndMarketingResponseDto businessAndMarketingResponseDto)
    {
        businessAndMarketingService.deleteBusinessAndMarketing(id, businessAndMarketingResponseDto);
    }

    @GetMapping("get-all")
    public List<BusinessAndMarketingResponseDto> getAllBusinessAndMarketing(){

        return businessAndMarketingService.getAllBusinessAndMarketing();
    }

    @GetMapping("get-by-id/{id}")
   public BusinessAndMarketingResponseDto getBusinessAndMarketingById(@PathVariable Long id){

        return businessAndMarketingService.getBusinessAndMarketingById(id);
   }

   @GetMapping("/fk-user-id/{fkUserId}")
    public BusinessAndMarketingResponseDto getBusinessAndMarketingByUserId(@PathVariable Long fkUserId){
        return businessAndMarketingService.getBusinessAndMarketingByUserId(fkUserId);
    }

    @GetMapping("/get-users-by-service-name/{businessAndMarketingName}")
    public List<UserResponseDto> getAllUserByBusinessAndMarketingName(@PathVariable String businessAndMarketingName){
        return businessAndMarketingService.getAllUserByBusinessAndMarketingName(businessAndMarketingName);
    }

    @GetMapping("/get-all-users-service-name-and-region/{businessAndMarketingName}/{region}")
    public List<UserResponseDto> getAllUserByBusinessAndMarketingNameAndRegion(
            @PathVariable String businessAndMarketingName, @PathVariable String region)
    {
        return businessAndMarketingService.
                getAllUserByBusinessAndMarketingNameAndRegion(businessAndMarketingName, region);
    }

}
