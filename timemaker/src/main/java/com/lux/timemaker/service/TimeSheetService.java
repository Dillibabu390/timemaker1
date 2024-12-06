package com.lux.timemaker.service;
import com.lux.timemaker.entity.TimeSheet;
import com.lux.timemaker.response.TimeSheetDto;
import com.lux.timemaker.spec.TimeSheetSpecification;
import com.lux.timemaker.repository.TimeSheetRepository;
import com.lux.timemaker.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@EnableCaching
@Slf4j
public class TimeSheetService {

    private final TimeSheetRepository timeSheetRepository;

    public TimeSheet createTimeSheet(TimeSheetDto timeSheetDto) {
        TimeSheet timeSheet = TimeSheet.builder()
                .userId(SecurityUtil.getCurrentUserId())
                .date(timeSheetDto.getDate())
                .startTime(timeSheetDto.getStartTime())
                .endTime(timeSheetDto.getEndTime())
                .project(timeSheetDto.getProject())
                .task(timeSheetDto.getTask())
                .overTime(timeSheetDto.getOverTime())
                .build();
        return timeSheetRepository.save(timeSheet);
    }


    public Optional<TimeSheet> updateTimeSheet(UUID id, TimeSheetDto timeSheetDto) {
        TimeSheet timeSheet = TimeSheet.builder()
                .timeId(SecurityUtil.getCurrentUserId())
                .date(timeSheetDto.getDate())
                .startTime(timeSheetDto.getStartTime())
                .endTime(timeSheetDto.getEndTime())
                .project(timeSheetDto.getProject())
                .task(timeSheetDto.getTask())
                .overTime(timeSheetDto.getOverTime())
                .build();

        if (timeSheetRepository.existsById(id)) {
            timeSheet.setTimeId(id);
            return Optional.of(timeSheetRepository.save(timeSheet));
        }
        return Optional.empty();
    }


    @Cacheable(key = "#id", value = "TimeSheet")
    public Optional<TimeSheet> getTimeSheetById(UUID id) {
        log.info("getTimeSheetById");
        return timeSheetRepository.findById(id);
    }


    @Cacheable(value = "timeSheets")
    public List<TimeSheet> getAllTimeSheets() {
        return timeSheetRepository.findAll();
    }


    public List<TimeSheet> findByFilters(String name, LocalTime timeStart, LocalTime timeEnd, Date date) {
        Specification<TimeSheet> spec = TimeSheetSpecification.withFilters(name, timeStart, timeEnd, date);
        return timeSheetRepository.findAll(spec);
    }
}
