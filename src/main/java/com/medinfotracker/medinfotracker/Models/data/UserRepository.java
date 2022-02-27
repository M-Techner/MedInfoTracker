package com.medinfotracker.medinfotracker.Models.data;

import com.medinfotracker.medinfotracker.Models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}


