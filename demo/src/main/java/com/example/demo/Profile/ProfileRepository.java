package com.example.demo.Profile;

import java.io.IOException;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileRepository {
    Profile saveProfile(MultipartFile file, Profile profile) throws IOException;
    Profile getProfile(long id);
    List<Profile> getProfiles();
    List<Profile> filterProfiles(String gender, String birthYear, String casteGeneral, String occupationPlace, String occupationState, String maritialStatus);
}
