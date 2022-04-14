package com.medinfotracker.medinfotracker.models.data;

import com.medinfotracker.medinfotracker.models.Profile;
import com.medinfotracker.medinfotracker.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    Profile findByUserId(int userId);
//    Profile findByUserName(String userName);

//    @Transactional
//    @Modifying
//    @Query ("")
//    int updateProfile(String userPreferredName, String userPreferredPronouns,
//                      String userMedicalRecordName, String userAddress,  String userPhoneNumber,
//                      String userDateOfBirth, String emergencyName, String emergencyPhoneNumber, String emergencyRelationship,
//                      String primaryCarePhysicianName, String primaryCarePhysicianAddress, String primaryCarePhysicianPhoneNumber,
//                      String specialistName, String specialistPhoneNumber, String specialistType,
//                      String allergies, String medicalConditions);

}