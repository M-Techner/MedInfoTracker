package com.medinfotracker.medinfotracker.models.data;


import com.medinfotracker.medinfotracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

}
