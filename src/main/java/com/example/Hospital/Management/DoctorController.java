package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/Doctor")
public class DoctorController
{
    HashMap<Integer,Doctor> doctorDb = new HashMap<>(); // Doctor Database

    //Add Doctor information into Database
    @PostMapping("/addViaRequestBody")
    public String addDoctorViaRequestBody(@RequestBody Doctor doctor)
    {
        int key=doctor.getId();
        if(doctorDb.containsKey(key)==false)
        {
            doctorDb.put(key,doctor);
            return "Doctor Details added Successfully";
        }
        return "Doctor Already Exist";
    }

    //
}
