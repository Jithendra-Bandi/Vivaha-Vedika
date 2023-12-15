package com.example.demo.Profile;


import java.io.IOException;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;




@Service
public class ProfileService implements ProfileRepository {
    @Autowired
    private ProfileJpaRepository profileJpaRepository;



    @Override
    public Profile saveProfile(MultipartFile file, Profile profile) throws IOException {
        profile.setImage(file.getBytes());
        profileJpaRepository.save(profile);
        return profile;
    }

    @Override
    public Profile getProfile(long id) {
        try{
            Profile profile = profileJpaRepository.findById(id).get();
            return profile;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Profile> getProfiles() {
        return profileJpaRepository.findAll();
    }

    @Override
    public List<Profile> filterProfiles(String gender, String birthYear, String casteGeneral,
            String occupationPlace, String occupationState, String maritialStatus) {
                if (occupationPlace == "India"){
                    return profileJpaRepository.getIndian(gender, birthYear, casteGeneral, occupationPlace, occupationState, maritialStatus);
                    // return new ArrayList<>(filteredProfiles);
                    // return profiles;
                }
                else {
                    return profileJpaRepository.getAbroad(gender, birthYear, casteGeneral, occupationPlace, maritialStatus);
                    // ArrayList<Profile> profiles = new ArrayList<>(filteredProfiles);
                    // return profiles;
                }
    }






    

    


}
