package com.medinfotracker.medinfotracker.models.data;

import com.medinfotracker.medinfotracker.models.Profile;
import com.medinfotracker.medinfotracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
//    User findByUserId(Integer, userId);
}