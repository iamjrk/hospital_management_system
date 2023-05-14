package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Nurse")
public class NurseController
{
    //Calling Nurse Service with the help of object creation
    NurseService nurseService= new NurseService();

    //add nurse
    @PostMapping("/addViaBody")
    public String addNurse(@RequestBody Nurse nurse)
    {
        String ans= nurseService.addNurse(nurse);
        return ans;
    }

    //get list of nurses greater than certain age
    @GetMapping("/getListGreaterThanCertainAge")
    public List<Nurse> getListGreaterThanCertainAge(@RequestParam("age") Integer age)
    {
        List<Nurse> nurseList= nurseService.getListGreaterThanCertainAge(age);
        return nurseList;
    }

    //get list of nurses based on certain qualification
    @GetMapping("/getListBasedOnCertainQualification")
    public List<Nurse> getListBasedOnCertainQualification(@RequestParam("qualification") String qualification)
    {
        List<Nurse> nurseList=nurseService.getListBasedOnCertainQualification(qualification);
        return nurseList;
    }
}
