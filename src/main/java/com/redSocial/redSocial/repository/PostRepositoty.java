package com.redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redSocial.redSocial.entity.Post;

@Repository//definir la interfas como un repositorio
public interface  PostRepositoty extends JpaRepository<Post,Long> {
    
}
