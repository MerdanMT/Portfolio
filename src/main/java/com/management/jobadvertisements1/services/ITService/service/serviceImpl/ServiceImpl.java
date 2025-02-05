package com.management.jobadvertisements1.services.ITService.service.serviceImpl;

import com.management.jobadvertisements1.services.ITService.dto.request.ITCreateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.request.ITUpdateRequestDto;
import com.management.jobadvertisements1.services.ITService.dto.response.ITResponseDto;
import com.management.jobadvertisements1.services.ITService.entity.IT;
import com.management.jobadvertisements1.services.ITService.mapper.ITMapper;
import com.management.jobadvertisements1.services.ITService.repository.ITRepository;
import com.management.jobadvertisements1.services.ITService.service.ITService;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.mapper.UserMapper;
import com.management.jobadvertisements1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("itServiceImpl")
@RequiredArgsConstructor
public class ServiceImpl implements ITService {

    private final ITRepository itRepository;
    private final UserRepository userRepository;
    private final ITMapper itMapper;
    private final UserMapper userMapper;

    @Override
    public void addIT(ITCreateRequestDto itCreateRequestDto) {

        itRepository.save(itMapper.toIT(itCreateRequestDto));
    }

    @Override
    public void updateIT(Long id, ITUpdateRequestDto itUpdateRequestDto) {

        IT it = itRepository.findById(id).get();

        itRepository.save(itMapper.toIT(it,itUpdateRequestDto));

    }

    @Override
    public void deleteIT(Long id, ITResponseDto itResponseDto) {

        itRepository.deleteById(id);
    }

    @Override
    public List<ITResponseDto> getAllIT() {

        List<IT> its = itRepository.findAll();
        List<ITResponseDto> itResponseDtos = new ArrayList<>();
        for (IT it : its) {
            itResponseDtos.add(itMapper.toITResponse(it));
        }
        return itResponseDtos;
    }

    @Override
    public ITResponseDto getITById(Long id) {

        return itMapper.toITResponse(itRepository.findById(id).get());
    }

    @Override
    public ITResponseDto getITByUserId(Long fkUserId) {

        return itMapper.toITResponse(itRepository.getAllByFkUserId(fkUserId));
    }

    @Override
    public List<UserResponseDto> getAllUserByITName(String itName) {

        List<UserResponseDto> userList = new ArrayList<>();

        List<IT> itList = itRepository.getAllByNameLikeIgnoreCase(itName);

        for (IT it : itList) {

            long a = it.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList;

    }

    @Override
    public List<UserResponseDto> getAllUserByITNameAndRegion(String itName, String region) {

        List<UserResponseDto> userList = new ArrayList<>();

        List<IT> itList = itRepository.getAllByNameLikeIgnoreCase(itName);

        for (IT it : itList) {

            long a = it.getFkUserId();

            userList.add(userMapper.toUserResponseDto(userRepository.getUsersById(a)));

        }

        return userList.stream().filter(reg->reg.getRegion().equals(region)).toList();
    }
}
