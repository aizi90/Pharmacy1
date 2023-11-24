package com.example.controller;

import com.example.entities.Pharmacy;
import com.example.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/pharmacies")
@RequiredArgsConstructor

public class PharmacyController {

        private final PharmacyService pharmacyService;

        @GetMapping
        public List<Pharmacy> findAll(){
            return pharmacyService.findAll();
        }

        @PostMapping
        public String save(@RequestBody Pharmacy newPharmacy){
            pharmacyService.save(newPharmacy);
            return "successfully"+newPharmacy+"is saved";
        }

        @PostMapping("/{id}")
        public String update(@RequestBody Pharmacy newPharmacy,@PathVariable Long id){
            return pharmacyService.update(id,newPharmacy);
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable Long id){
            return pharmacyService.delete(id);
        }
    }
