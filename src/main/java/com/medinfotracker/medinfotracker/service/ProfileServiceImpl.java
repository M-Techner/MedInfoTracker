//package com.medinfotracker.medinfotracker.service;
//
//import com.medinfotracker.medinfotracker.models.Profile;
//import com.medinfotracker.medinfotracker.models.User;
//import com.medinfotracker.medinfotracker.models.data.ProfileRepository;
//import com.medinfotracker.medinfotracker.models.data.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class ProfileServiceImpl implements ProfileService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
////    public ProfileServiceImpl () {
////    }
//
//    @Override
//    public void updateProfile(Profile profile) {
//        this.profileRepository.save(profile);
//    }
//
//    @Override
//    public  Profile getProfileById(String userId) {
//        Optional<Profile> optional = profileRepository.findById(Integer.valueOf(userId));
//        Profile profile = null;
//        if (optional.isPresent()) {
//            profile = optional.get();
//        } else {
//            throw new RuntimeException(" No Profile Found");
//        }
//        return profile;
//    }
//
//    @Override
//    public void deleteProfileById(String userId) {
//        this.profileRepository.deleteById(Integer.valueOf(userId));
//    }
//}
