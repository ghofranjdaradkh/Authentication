package com.ghofranjdaradkh.AuthenticationSite.Repository;

import com.ghofranjdaradkh.AuthenticationSite.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts,Long> {
    List<Posts> findBySiteUserId(Long userId);


    List<Posts> findBySiteUser_Id(Long userId);
}
