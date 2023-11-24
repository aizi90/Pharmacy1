package com.example.service.serviceImpl;


import com.example.entities.Pharmacy;
import com.example.repository.PharmacyRepository;
import com.example.service.PharmacyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional

public class PharmacyServiceImpl  implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();

    }

    @Override
    public void save(Pharmacy newPharmacy) {
        pharmacyRepository.save(newPharmacy);

    }

    @Override
    public Pharmacy findById(Long id) {
        return pharmacyRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("Pharmacy with id: "+id+" not found"));
    }


}

    @Override
    public String update(Long id, Pharmacy newPharmacy) {
        Pharmacy currentPharmacy = findById(id);
        currentPharmacy.setName(newPharmacy.getName());
        currentPharmacy.setAddress(newPharmacy.getAddress());
        return "successfully update";
    }


    @Override
    public String delete(Long id) {
          return "Pharmacy: "+id+" is deleted";
    }
    }




