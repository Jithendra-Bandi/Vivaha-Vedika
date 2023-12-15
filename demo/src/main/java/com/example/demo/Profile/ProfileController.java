package com.example.demo.Profile;

import java.io.IOException;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin("http://127.0.0.1:3000")
@Controller
// @RestController
public class ProfileController {
    @Autowired
    public ProfileService profileService;


    // GetMapping ==========================================================================


    @GetMapping("/")
    public String profiles() {
        return "profile-display";
    }
    @GetMapping("/registration")
    public String display() {
        return "index";
    }



    
    @GetMapping("/profile/{id}")
    @ResponseBody
    public Profile getProfile(@PathVariable long id) {
        return profileService.getProfile(id);
    }

    @GetMapping("/profiles")
    @ResponseBody
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }


    
    // PostMapping =========================================================================
    @ResponseBody
    @PostMapping("/register/profile")
    public Profile saveProfile(@RequestParam("file") MultipartFile file, @ModelAttribute Profile profile) throws IOException {
        return profileService.saveProfile(file, profile);
    }
    @ResponseBody
    @PostMapping("/filter")
    public List<Profile> filterProfiles(
        @RequestParam("gender") String gender,
        @RequestParam("birthYear") String birthYear,
        @RequestParam("casteGeneral") String casteGeneral,
        @RequestParam("occupationPlace") String occupationPlace,
        @RequestParam("occupationState") String occupationState,
        @RequestParam("maritialStatus") String maritialStatus
        ) {
            return profileService.filterProfiles(gender, birthYear, casteGeneral, occupationPlace, occupationState, maritialStatus);
        }







   
   
}
