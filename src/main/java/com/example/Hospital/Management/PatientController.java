package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Patient")
public class PatientController
{
    HashMap<Integer,Patient> patientDb= new HashMap<>();
    @PostMapping("/addViaParams")
    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,
                             @RequestParam("disease")String disease,@RequestParam("age")Integer age)
    {
        Patient patient= new Patient(patientId,name,disease,age);
        patientDb.put(patientId,patient);
        return "Patient Added Successfully via Parameter";
    }

    @PostMapping("/addViaBody")
    public String addPatient(@RequestBody Patient patient)
    {
        int key=patient.getPatientId();
        patientDb.put(key,patient);

        return "Patient Added Successfully via Body";
    }

//    @PostMapping("/addPatientViaPathVariable/{patientId}")
//    public Patient addPatient(@PathVariable("patientId")Integer patientId)
//    {
//
//    }
    //Note: While Using PathVariables i/p has to be given in address itself
    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getInfoViaPath(@PathVariable("patientId")Integer patientId)
    {
        int key=patientId;
        return patientDb.get(key);
    }
    @GetMapping("/getInfoViaPathVariable/{patientId}/{name}")
    public Patient getInfoViaPath(@PathVariable("patientId")Integer patientId,@PathVariable("name")String name)
    {
        int key=patientId;
        if(patientDb.containsKey(key)&& patientDb.get(key).getName().equals(name))
        {
            return patientDb.get(key);
        }
        return null;
    }
    @GetMapping("/Info")
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
            if (p.getName().equals(name))
                return p;
        }

        return null;
    }

    @GetMapping("/ListGreaterThan")
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
    //Using Path Variables find list of patient having age > 22 and disease cold
    @GetMapping("/ListForAgeAndDisease/{age}/{disease}")
    public List<Patient>patientList(@PathVariable("age")Integer age,@PathVariable("disease")String disease) {
        List<Patient> list = new ArrayList<>();
        for (Patient p : patientDb.values()) {
            if (p.getAge() > age && p.getDisease().equals(disease)) {
                list.add(p);
            }
        }
        return list;
    }
    // Update Mapping Syntax & Examples
    @PutMapping("/updateDetails")
    public String updatePatientDetails(@RequestBody Patient patient)
    {

        if(patientDb.containsKey(patient.getPatientId()))
        {
            int key= patient.getPatientId();
            patientDb.put(key,patient);
            return "Patient Details Update Successfully...";
        }
        return "Patient Details Does Not Match!!!";
    }

    //Delete Mapping Syntax & Example
    @DeleteMapping("/delete")
    public String deletePatientDetails(@RequestParam("patientId") Integer patientId)
    {
        if(patientDb.containsKey(patientId))
        {
            patientDb.remove(patientId);
            return "Patient Information Deleted Successfully...";
        }
        return "Patient Does Not Exist!!!";
    }
}
