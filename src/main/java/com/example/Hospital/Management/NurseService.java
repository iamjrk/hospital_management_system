package com.example.Hospital.Management;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService
{
    //Calling the Nurse Repository by creating its object
    NurseRepository nurseRepository= new NurseRepository();
    //Service Layer Contains the logic part & Validation,i.e Edge Cases, Invalid Inputs etc.
    public String addNurse(Nurse nurse)
    {
        if(nurse.getId()<=0) return "Id has to be a natural number";
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getListGreaterThanCertainAge(int age)
    {
        //calling all nurses from database
        List<Nurse> nurseList = nurseRepository.getAllInfo();

        //Now I am writing the logic to extract required info
        List<Nurse> finalNurseList= new ArrayList<>();
        for(Nurse nurse: nurseList)
        {
            if(nurse.getAge()>age)
            {
                finalNurseList.add(nurse);
            }
        }
        return finalNurseList;
    }

    public List<Nurse> getListBasedOnCertainQualification(String qualification)
    {
        //calling all nurses from database
        List<Nurse> nurseList=nurseRepository.getAllInfo();

        //Now I am writing the logic to extract required info
        List<Nurse>finalNurseList= new ArrayList<>();

        for (Nurse nurse:nurseList)
        {
            if(nurse.getQualification().equals(qualification))
            {
                finalNurseList.add(nurse);
            }
        }
        return finalNurseList;
    }
}
