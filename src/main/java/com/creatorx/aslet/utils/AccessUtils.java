package com.creatorx.aslet.utils;

import com.creatorx.aslet.dto.RequestMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessUtils {
    @Autowired
    private RequestMetadata requestMetadata;

    public boolean isAdmin() {
        String role = requestMetadata.getRole();
        return role != null && role.equals("admin");
    }

    public boolean doesBelongToUser(Long id) {
        Long userId = requestMetadata.getId();
        return userId != null && userId.equals(id);
    }

    public Long getUserId() {
        return requestMetadata.getId();
    }
}
