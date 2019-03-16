package com.example.demo.repository;

import com.example.demo.model.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDO, Long> {
    UserDO findByUsername(String username);
}
