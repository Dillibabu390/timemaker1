package com.lux.timemaker.util;

import com.lux.timemaker.service.UserInfoDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class SecurityUtil {
    public SecurityUtil() {}

    public static UUID getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null) {
            throw new IllegalStateException("No authentication found in security context");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserInfoDetails) {
            UserInfoDetails userInfoDetails = (UserInfoDetails) principal;
            return userInfoDetails.getId();
        } else {
            throw new IllegalStateException("Principal is not of expected type: UserInfoDetails");
        }
    }
}
