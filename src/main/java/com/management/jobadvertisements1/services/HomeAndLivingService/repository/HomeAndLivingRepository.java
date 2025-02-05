package com.management.jobadvertisements1.services.HomeAndLivingService.repository;

import com.management.jobadvertisements1.services.HomeAndLivingService.entity.HomeAndLiving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeAndLivingRepository extends JpaRepository<HomeAndLiving, Long> {

    HomeAndLiving getAllByFkUserId(Long fkUserId);

    List<HomeAndLiving> getAllByNameLikeIgnoreCase(String name);

}
