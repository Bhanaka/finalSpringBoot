package com.wings.usermanagement.Repository;

import com.wings.usermanagement.Model.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<TbUser,Long> {
//    Optional<TbUser> findByUsername(String username) ;
}
