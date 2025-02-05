package com.management.jobadvertisements1.services.HomeAndLivingService.controller;

import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingCreateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingUpdateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.response.HomeAndLivingResponse;
import com.management.jobadvertisements1.services.HomeAndLivingService.service.HomeAndLivingService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home_and_living")
@RequiredArgsConstructor
public class HomeAndLivingController {

    private final HomeAndLivingService homeAndLivingService;

   @PostMapping
   public void addHomeAndLiving(@RequestBody HomeAndLivingCreateRequest homeAndLivingCreateRequest){
       homeAndLivingService.addHomeAndLiving(homeAndLivingCreateRequest);
   }

   @PutMapping("/{id}")
    public void updateHomeAndLiving(@PathVariable Long id,
                                    @RequestBody HomeAndLivingUpdateRequest homeAndLivingUpdateRequest)
   {
       homeAndLivingService.updateHomeAndLiving(id, homeAndLivingUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteHomeAndLiving(@PathVariable Long id,
                                    @RequestBody HomeAndLivingResponse homeAndLivingResponse)
    {
       homeAndLivingService.deleteHomeAndLiving(id, homeAndLivingResponse);
    }

    @GetMapping("get-all")
    public List<HomeAndLivingResponse> getAllHomeAndLiving(){
       return homeAndLivingService.getAllHomeAndLiving();
    }

    @GetMapping("/{id}")
    public HomeAndLivingResponse getHomeAndLivingById(@PathVariable Long id){
       return homeAndLivingService.getHomeAndLivingById(id);
    }

    @GetMapping("/{fkUserId}")
    public HomeAndLivingResponse getHomeAndLivingByUserId(@PathVariable Long fkUserId){
       return homeAndLivingService.getHomeAndLivingByUserId(fkUserId);
    }

    @GetMapping("/get-all-user-by-service-name-living/{homeAndLivingName}")
    public List<UserResponseDto> getAllUserByHomeAndLivingName(@PathVariable String homeAndLivingName){
       return homeAndLivingService.getAllUserByHomeAndLivingName(homeAndLivingName);
    }

    @GetMapping("/get-all-users-by-service-name-and-region/{homeAndLivingName}/{region}")
   public List<UserResponseDto> getAllUserByHomeAndLivingNameAndRegion(@PathVariable String homeAndLivingName, @PathVariable String region){
       return homeAndLivingService.getAllUserByHomeAndLivingNameAndRegion(homeAndLivingName, region);
   }

}
