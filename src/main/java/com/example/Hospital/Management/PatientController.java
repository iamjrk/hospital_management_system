package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController
{
    HashMap<Integer,Patient> patientDb= new HashMap<>();
    @PostMapping("/addPatientViaParams")
    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,
                             @RequestParam("disease")String disease,@RequestParam("age")Integer age)
    {
        Patient patient= new Patient(patientId,name,disease,age);
        patientDb.put(patientId,patient);
        return "Patient Added Successfully via Parameter";
    }

    @PostMapping("/addPatientViaBody")
    public String addPatient(@RequestBody Patient patient)
    {
        int key=patient.getPatientId();
        patientDb.put(key,patient);

        return "Patient Added Successfully via Body";
    }

    @GetMapping("/patientInfo")
    public Patient getInfo(@RequestParam("patientId") Integer patientId)
    {
        int key=patientId;
        Patient patient=patientDb.get(key);
        return patient;
    }

    @GetMapping("/getAllInfo")
    public List<Patient> allInfo()
    {
        List<Patient> patientList= new ArrayList<>();
        for(int key: patientDb.keySet())
        {
            patientList.add(patientDb.get(key));
        }
        return patientList;
    }

    @GetMapping("/searchByName")
    public Patient searching(@RequestParam("name") String name)
    {
        for(Patient p:patientDb.values())
        {
//            if(name==p.getName())
//            {
//                return p;
//            }
            if (p.getName().equals(name))
                return p;
        }

        return null;
    }

    @GetMapping("/patientListGreaterThan")
    public List<Patient> makeList(@RequestParam("age")Integer age)
    {
        List<Patient> patientList= new ArrayList<>();
        for(Patient patient:patientDb.values())
        {
            if(patient.getAge()>age)
                patientList.add(patient);
        }
        return patientList;
    }
}
