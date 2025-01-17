package com.lux.timemaker.repository;
import com.lux.timemaker.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserInfoRepository  extends JpaRepository<UserInfo, UUID> {

    Optional<UserInfo> findByEmail(String email);

    Optional<UserInfo> findByName(String name);
}
