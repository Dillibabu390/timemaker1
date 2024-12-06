package com.lux.timemaker.repository;
import com.lux.timemaker.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, UUID>, JpaSpecificationExecutor<TimeSheet> {
}
