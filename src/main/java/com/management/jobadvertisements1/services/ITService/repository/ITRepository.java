package com.management.jobadvertisements1.services.ITService.repository;

import com.management.jobadvertisements1.services.ITService.entity.IT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITRepository  extends JpaRepository<IT, Long> {

    IT getAllByFkUserId(Long fkUserId);

    List<IT> getAllByNameLikeIgnoreCase(String name);

}
