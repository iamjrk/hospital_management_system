package com.example.Hospital.Management;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository
{
    HashMap<Integer,Nurse> nurseDb= new HashMap<>();
    public String addNurse(Nurse nurse)
    {
        int key= nurse.getId();
        if(!nurseDb.containsKey(key))
        {
            nurseDb.put(key,nurse);
            return "Nurse added Successfully...";
        }
        return "Nurse is already added";
    }

    public List<Nurse> getAllInfo()
    {
        //return nurseDb.values().stream().toList(); //one way

        //another way below
        List<Nurse> nurseList=new ArrayList<>();
        for(Nurse n:nurseDb.values())
        {
            nurseList.add(n);
        }
        return nurseList;
    }
}
