package com.medinfotracker.medinfotracker.models.data;

<<<<<<< HEAD
import com.medinfotracker.medinfotracker.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
=======

import com.medinfotracker.medinfotracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String username);
}