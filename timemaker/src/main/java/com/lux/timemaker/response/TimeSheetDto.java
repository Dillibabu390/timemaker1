package com.lux.timemaker.response;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeSheetDto {


    @NotNull(message = "Date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull(message = "Start time cannot be null")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @NotNull(message = "End time cannot be null")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    @NotEmpty(message = "Project cannot be empty")
    private String project;

    @NotEmpty(message = "Task cannot be empty")
    private String task;

    private Boolean overTime;

    private UUID userId;

}
