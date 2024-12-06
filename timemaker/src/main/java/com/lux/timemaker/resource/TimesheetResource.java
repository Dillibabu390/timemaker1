package com.lux.timemaker.resource;
import com.lux.timemaker.entity.TimeSheet;
import com.lux.timemaker.response.TimeSheetDto;
import com.lux.timemaker.service.TimeSheetService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/timesheet/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class
TimesheetResource {


    private final TimeSheetService timeSheetService;


    @Operation(
            description = "Create a new time sheet for the specified employee",
            summary = "Create a time sheet record"
    )
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_EMP')")
    public ResponseEntity<?> createTimeSheet(@Valid @RequestBody TimeSheetDto timeSheetDto) {
        TimeSheet createdTimeSheet = timeSheetService.createTimeSheet(timeSheetDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimeSheet);
    }


    @Operation(
            description = "Update an existing time sheet for the specified employee",
            summary = "Update a time sheet record"
    )
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_EMP')")
    public ResponseEntity<?> updateTimeSheet(@PathVariable("id") UUID id, @Valid @RequestBody TimeSheetDto timeSheetDto) {
        Optional<TimeSheet> updatedTimeSheet = timeSheetService.updateTimeSheet(id, timeSheetDto);
      return ResponseEntity.status(HttpStatus.OK).body(updatedTimeSheet.get());
    }

    @Operation(
            description = "Retrieve the time sheet details for the specified employee by ID",
            summary = "Get a time sheet by ID"
    )
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_EMP')")
    public ResponseEntity<?> getTimeSheetById(@PathVariable("id") UUID id) {
        Optional<TimeSheet> timeSheet = timeSheetService.getTimeSheetById(id);
        return ResponseEntity.status(HttpStatus.OK).body(timeSheet.get());
    }

    @Operation(
            description = "Retrieve a list of all time sheets for the authenticated employee",
            summary = "Get all time sheets"
    )
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_EMP')")
    public List<TimeSheet> getAllTimeSheets() {
        return timeSheetService.getAllTimeSheets();
    }


    @Operation(
            description = "Search for time sheets based on start time, end time, and date filters",
            summary = "Search time sheets by filters"
    )
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<TimeSheet> searchTimeSheets(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) @DateTimeFormat(pattern = "HH:mm:ss") LocalTime timeStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = "HH:mm:ss") LocalTime timeEnd,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        return timeSheetService.findByFilters(name, timeStart, timeEnd, date);
    }
}
