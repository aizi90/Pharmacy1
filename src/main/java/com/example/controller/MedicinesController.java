package com.example.controller;

import com.example.entities.Medicines;
import com.example.service.MedicinesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicines/{pharmacyId}")
@RequiredArgsConstructor

public class MedicinesController {
    private final MedicinesService medicinesService;

    @GetMapping
    public List<Medicines> findById(@PathVariable Long pharmacyId){
        return medicinesService.findById(id);
    }
    @PostMapping
    public String save(@RequestBody Medicines medicines,
                       @PathVariable Long pharmacyId){
        medicinesService.save(pharmacyId,medicines);
        return "Medicine "+medicines+" is saved";

    }
}
