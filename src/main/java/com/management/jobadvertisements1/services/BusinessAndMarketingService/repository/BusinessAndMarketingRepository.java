package com.management.jobadvertisements1.services.BusinessAndMarketingService.repository;

import com.management.jobadvertisements1.services.BusinessAndMarketingService.entity.BusinessAndMarketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessAndMarketingRepository extends JpaRepository<BusinessAndMarketing, Long> {

    BusinessAndMarketing getAllByFkUserId(Long fkUserId);

    List<BusinessAndMarketing> getAllByNameLikeIgnoreCase(String name);

}
