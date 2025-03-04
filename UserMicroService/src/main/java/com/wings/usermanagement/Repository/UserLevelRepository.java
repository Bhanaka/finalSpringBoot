package com.wings.usermanagement.Repository;

import com.wings.usermanagement.Model.TbUserLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLevelRepository extends JpaRepository<TbUserLevel , Long> {
}
