package com.example.service;
import com.example.entities.Pharmacy;

import java.util.List;

public interface PharmacyService {
  List<Pharmacy> findAll();
 void save(Pharmacy newPharmacy) ;
 Pharmacy findById(Long id);
 String update(Long id, Pharmacy newPharmacy);
 String delete(Long id) ;
}
