package com.ghofranjdaradkh.AuthenticationSite.Repository;

import com.ghofranjdaradkh.AuthenticationSite.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<SiteUser,Long> {

    SiteUser findByUsername(String username);
//
//    SiteUser getCurrentUserByUsername(String username);
//


}
