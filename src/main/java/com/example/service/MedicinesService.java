package com.example.service;

import com.example.entities.Medicines;




public interface MedicinesService {

 void save(Long pharmacyId, Medicines medicines);

 Medicines findById(Long id);

 String update(Long id, Medicines newMedicine);
}