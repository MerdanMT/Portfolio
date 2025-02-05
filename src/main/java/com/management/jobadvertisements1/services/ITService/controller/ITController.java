package com.management.jobadvertisements1.services.ITService.controller;

import com.management.jobadvertisements1.services.ITService.dto.request.ITCreateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.request.ITUpdateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.response.ITResponseDto;
import com.management.jobadvertisements1.services.ITService.service.ITService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/IT")
@RequiredArgsConstructor
public class ITController {

    private final ITService itService;

    @PostMapping
    public void addIT(@RequestBody ITCreateRequestDto itCreateRequestDto){
        itService.addIT(itCreateRequestDto);
    }

    @PutMapping("/{id}")
    public void updateIT(@PathVariable Long id, @RequestBody ITUpdateRequestDto itUpdateRequestDto){
        itService.updateIT(id, itUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteIT(@PathVariable Long id, @RequestBody ITResponseDto itResponseDto){
        itService.deleteIT(id, itResponseDto);
    }

    @GetMapping("/get-all")
    public List<ITResponseDto> getAllIT(){
        return itService.getAllIT();
    }

    @GetMapping("/get-id/{id}")
    public ITResponseDto getITById(@PathVariable Long id){
        return itService.getITById(id);
    }

    @GetMapping("/get-fk-user-id/{fkUserId}")
    public ITResponseDto getITByUserId(@PathVariable Long fkUserId){
        return itService.getITByUserId(fkUserId);
    }

    @GetMapping("/get-all-user-by-IT-name/{itName}")
    public List<UserResponseDto> getAllUserByITName(@PathVariable String itName){
        return itService.getAllUserByITName(itName);
    }

    @GetMapping("/get-all-users-by-service-name-and-region/{itName}{region}")
    public List<UserResponseDto> getAllUserByITNameAndRegion(@PathVariable String itName, @PathVariable String region){
        return itService.getAllUserByITNameAndRegion(itName, region);
    }
}
