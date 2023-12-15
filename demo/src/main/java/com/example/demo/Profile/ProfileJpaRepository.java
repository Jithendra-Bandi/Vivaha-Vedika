package com.example.demo.Profile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileJpaRepository extends JpaRepository<Profile, Long>{
    @Query(value="SELECT s from Profile s WHERE gender=:gender and  birthYear=:birthYear and casteGeneral=:casteGeneral and occupationPlace=:occupationPlace and occupationState=:occupationState and maritialStatus=:maritialStatus")
    public List<Profile> getIndian(@Param("gender") String gender, @Param("birthYear") String birthYear, @Param("casteGeneral") String casteGeneral, @Param("occupationPlace") String occupationPlace, @Param("occupationState") String occupationState, @Param("maritialStatus") String maritialStatus); 
    
    @Query(value="SELECT s from Profile s WHERE gender=:gender and  birthYear=:birthYear and casteGeneral=:casteGeneral and occupationPlace=:occupationPlace and maritialStatus=:maritialStatus")
    public List<Profile> getAbroad(@Param("gender") String gender, @Param("birthYear") String birthYear, @Param("casteGeneral") String casteGeneral, @Param("occupationPlace") String occupationPlace, @Param("maritialStatus") String maritialStatus); 
}
