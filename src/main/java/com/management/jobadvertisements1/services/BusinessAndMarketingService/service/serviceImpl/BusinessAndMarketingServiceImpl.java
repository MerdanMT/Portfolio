package com.management.jobadvertisements1.services.BusinessAndMarketingService.service.serviceImpl;

import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingCreateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request.BusinessAndMarketingUpdateRequestDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.response.BusinessAndMarketingResponseDto;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.entity.BusinessAndMarketing;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.mapper.BusinessAndMarketingMapper;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.repository.BusinessAndMarketingRepository;
import com.management.jobadvertisements1.services.BusinessAndMarketingService.service.BusinessAndMarketingService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.mapper.UserMapper;
import com.management.jobadvertisements1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessAndMarketingServiceImpl implements BusinessAndMarketingService {

    private final BusinessAndMarketingRepository businessAndMarketingRepository;
    private final BusinessAndMarketingMapper businessAndMarketingMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    //    @Override
//    public void addBusinessAndMarketing(BusinessAndMarketingCreateRequestDto businessAndMarketingCreateRequestDto) {
//
//        List<String> list = new ArrayList<>();
//        list.add("Advertising and marketing");
//        list.add("Product and brand strategy");
//        list.add("Consulting and management services");
//        list.add("Supply chain and logistics");
//        for (String s : list) {
//            if (s.equals(businessAndMarketingCreateRequestDto.getName())) {
//                businessAndMarketingRepository.save(businessAndMarketingMapper.toBusinessAndMarketing(businessAndMarketingCreateRequestDto));
//                break;
//            }
//        }
//    }
    @Override
    public void addBusinessAndMarketing(BusinessAndMarketingCreateRequestDto businessAndMarketingCreateRequestDto) {

        businessAndMarketingRepository.save(businessAndMarketingMapper.toBusinessAndMarketing(businessAndMarketingCreateRequestDto));
    }


    @Override
    public void updateBusinessAndMarketing(
            Long id, BusinessAndMarketingUpdateRequestDto businessAndMarketingUpdateRequestDto) {

        BusinessAndMarketing businessAndMarketing1 = businessAndMarketingRepository.findById(id).get();

        businessAndMarketingRepository.save(businessAndMarketingMapper.
                toBusinessAndMarketing(businessAndMarketing1,businessAndMarketingUpdateRequestDto));
    }

    @Override
    public void deleteBusinessAndMarketing(
            Long id,BusinessAndMarketingResponseDto businessAndMarketingResponseDto) {

        businessAndMarketingRepository.deleteById(id);

    }

    @Override
    public List<BusinessAndMarketingResponseDto> getAllBusinessAndMarketing() {

        List<BusinessAndMarketing> businessAndMarketingList = businessAndMarketingRepository.findAll();
        List<BusinessAndMarketingResponseDto> businessAndMarketingResponseDtoList = new ArrayList<>();
        for (BusinessAndMarketing b : businessAndMarketingList) {
            businessAndMarketingResponseDtoList.add(
                    businessAndMarketingMapper.toBusinessAndMarketingResponseDto(b));
        }
        return businessAndMarketingResponseDtoList;
    }

    @Override
    public BusinessAndMarketingResponseDto getBusinessAndMarketingById(Long id) {

        BusinessAndMarketing businessAndMarketing = businessAndMarketingRepository.findById(id).get();

        return businessAndMarketingMapper.toBusinessAndMarketingResponseDto(businessAndMarketing);
    }

    @Override
    public BusinessAndMarketingResponseDto getBusinessAndMarketingByUserId(Long fkUserId) {

        return businessAndMarketingMapper.toBusinessAndMarketingResponseDto(
                businessAndMarketingRepository.getAllByFkUserId(fkUserId));
    }

    @Override
    public List<UserResponseDto> getAllUserByBusinessAndMarketingName(String businessAndMarketingName) {

        List<UserResponseDto> userList = new ArrayList<>();
        List<BusinessAndMarketing> b = businessAndMarketingRepository.getAllByNameLikeIgnoreCase(businessAndMarketingName);
        for (BusinessAndMarketing businessAndMarketing : b) {

            long a = businessAndMarketing.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList;

    }

    @Override
    public List<UserResponseDto> getAllUserByBusinessAndMarketingNameAndRegion(String businessAndMarketingName, String region) {

        List<UserResponseDto> userList = new ArrayList<>();

        List<BusinessAndMarketing> b = businessAndMarketingRepository.getAllByNameLikeIgnoreCase(businessAndMarketingName);

        for (BusinessAndMarketing businessAndMarketing : b) {

            long a = businessAndMarketing.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList.stream().filter(reg->reg.getRegion().equals(region)).toList();

    }

}
