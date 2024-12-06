package com.lux.timemaker.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import java.util.UUID;


@Entity
@Table(name = "timesheets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class TimeSheet extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "time_id", nullable = false)
    private UUID timeId;

    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "project")
    private String project;

    @Column(name = "task")
    private String task;

    @Column(name = "over_time")
    private Boolean overTime;

    @Column(name = "user_id")
    private UUID userId;


}
