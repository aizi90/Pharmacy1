package com.example.service.serviceImpl;


import com.example.entities.Medicines;
import com.example.entities.Pharmacy;
import com.example.repository.MedicinesRepository;
import com.example.repository.PharmacyRepository;
import com.example.service.MedicinesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor

public class MedicinesServiceImpl implements MedicinesService {
    private MedicinesRepository medicinesRepository;
    private final PharmacyRepository pharmacyRepository;

    @Override
    public List<Medicines> getAllPriceBySort() {
        return medicinesRepository.findAll();
    }

    @Override
    public void save(Long pharmacyId, Medicines medicines) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow(() ->
                new NoSuchElementException("Pharmacy with id: " + pharmacyId + " not found"));
        pharmacy.getMedicines().add(medicines);
        medicines.getPharmacy().add(pharmacy);
        medicinesRepository.save(medicines);
    }

    @Override
    public Medicines findById(Long id) {
        return medicinesRepository.findById(id).orElseThrow(()->
                new NullPointerException("Medicine with id: "+id+" not found"));
    }

    @Override
    public String update(Long id, Medicines newMedicine) {
        Medicines medicines = findById(id);
        medicines.setName(newMedicine.getName());
        medicines.setPrice(newMedicine.getPrice());
        medicines.setPharmacy(newMedicine.getPharmacy());
        return "Successfully updated";
    }
    }


