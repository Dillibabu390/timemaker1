package com.lux.timemaker.spec;

import com.lux.timemaker.entity.TimeSheet;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalTime;
import java.util.Date;

public class TimeSheetSpecification {

    public static Specification<TimeSheet> withFilters(String name, LocalTime timeStart, LocalTime timeEnd, Date date) {
        return (Root<TimeSheet> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();  // Start with an empty conjunction

            if (name != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("name"), name));
            }

            // Filter by timeStart (if present)
            if (timeStart != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("timeStart"), timeStart));
            }

            // Filter by timeEnd (if present)
            if (timeEnd != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("timeEnd"), timeEnd));
            }

            // Filter by date (if present)
            if (date != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date"), date));
            }

            return predicate;
        };
    }
}
