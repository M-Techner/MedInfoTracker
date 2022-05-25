package com.medinfotracker.medinfotracker.models.data;

import com.medinfotracker.medinfotracker.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
//    Optional findById(int userId);
}
