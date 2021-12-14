package com.janadeve.janadeveportalbackend.repositories;

import com.janadeve.janadeveportalbackend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
