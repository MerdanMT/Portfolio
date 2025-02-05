package com.management.jobadvertisements1.services.MedicalService.repository;

import com.management.jobadvertisements1.services.MedicalService.entity.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface MedicalRepository extends JpaRepository<Medical, Long> {

    Medical getAllByFkUserId(Long fkUserId);

    List<Medical> getAllByNameLikeIgnoreCase(String name);
}
