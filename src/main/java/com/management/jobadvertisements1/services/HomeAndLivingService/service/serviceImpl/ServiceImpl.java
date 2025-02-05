package com.management.jobadvertisements1.services.HomeAndLivingService.service.serviceImpl;

import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingCreateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.request.HomeAndLivingUpdateRequest;
import com.management.jobadvertisements1.services.HomeAndLivingService.dto.response.HomeAndLivingResponse;
import com.management.jobadvertisements1.services.HomeAndLivingService.entity.HomeAndLiving;
import com.management.jobadvertisements1.services.HomeAndLivingService.mapper.HomeAndLivingMapper;
import com.management.jobadvertisements1.services.HomeAndLivingService.repository.HomeAndLivingRepository;
import com.management.jobadvertisements1.services.HomeAndLivingService.service.HomeAndLivingService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.mapper.UserMapper;
import com.management.jobadvertisements1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("homeAndLivingServiceImpl")
@RequiredArgsConstructor
public class ServiceImpl implements HomeAndLivingService {

    private final HomeAndLivingRepository homeAndLivingRepository;
    private final UserRepository userRepository;
    private final HomeAndLivingMapper homeAndLivingMapper;
    private final UserMapper userMapper;

    @Override
    public void addHomeAndLiving(HomeAndLivingCreateRequest homeAndLivingCreateRequest) {

        homeAndLivingRepository.save(homeAndLivingMapper.toHomeAndLiving(homeAndLivingCreateRequest));
    }

    @Override
    public void updateHomeAndLiving(Long id, HomeAndLivingUpdateRequest homeAndLivingUpdateRequest) {

        HomeAndLiving homeAndLiving = homeAndLivingRepository.findById(id).orElse(null);

        homeAndLivingRepository.save(homeAndLivingMapper.
                toHomeAndLiving(homeAndLiving,homeAndLivingUpdateRequest));
    }

    @Override
    public void deleteHomeAndLiving(Long id, HomeAndLivingResponse homeAndLivingResponse) {

        homeAndLivingRepository.deleteById(id);
    }

    @Override
    public List<HomeAndLivingResponse> getAllHomeAndLiving() {

        List<HomeAndLiving> homeAndLiving = homeAndLivingRepository.findAll();
        List<HomeAndLivingResponse> homeAndLivingResponses = new ArrayList<>();

        for (HomeAndLiving homeAndLiv : homeAndLiving) {
            homeAndLivingResponses.add(homeAndLivingMapper.toHomeAndLivingResponse(homeAndLiv));
        }

        return homeAndLivingResponses;
    }

    @Override
    public HomeAndLivingResponse getHomeAndLivingById(Long id) {

        HomeAndLiving homeAndLiving = homeAndLivingRepository.findById(id).orElse(null);

        return homeAndLivingMapper.toHomeAndLivingResponse(homeAndLiving);
    }

    @Override
    public HomeAndLivingResponse getHomeAndLivingByUserId(Long fkUserId) {

        return homeAndLivingMapper.toHomeAndLivingResponse(
                homeAndLivingRepository.getAllByFkUserId(fkUserId));
    }

    @Override
    public List<UserResponseDto> getAllUserByHomeAndLivingName(String homeAndLivingName) {
        List<UserResponseDto> userList = new ArrayList<>();
        List<HomeAndLiving> b = homeAndLivingRepository.getAllByNameLikeIgnoreCase(homeAndLivingName);
        for (HomeAndLiving homeAndLiving : b) {

            long a = homeAndLiving.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList;

    }

    @Override
    public List<UserResponseDto> getAllUserByHomeAndLivingNameAndRegion(String homeAndLivingName, String region) {

        List<UserResponseDto> userList = new ArrayList<>();
        List<HomeAndLiving> b = homeAndLivingRepository.getAllByNameLikeIgnoreCase(homeAndLivingName);
        for (HomeAndLiving homeAndLiving : b) {

            long a = homeAndLiving.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList.stream().filter(reg->reg.getRegion().equals(region)).toList();
    }

}
