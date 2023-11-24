package com.example.service.serviceImpl;


import com.example.entities.Pharmacy;
import com.example.entities.Worker;
import com.example.repository.PharmacyRepository;
import com.example.repository.WorkerRepository;
import com.example.service.WorkerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Transactional

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final PharmacyRepository pharmacyRepository;



    @Override
    public void save(Worker newWorker, Long pharmacyId) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow(
                () -> new NoSuchElementException("Pharmacy with id:" + " not found"));
        pharmacy.getWorkers().add(newWorker);
        newWorker.setPharmacy(pharmacy);
        workerRepository.save(newWorker);
    }

    @Override
    public Worker findById(Long id) {
        return workerRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("Worker with id:"+id+" not found"));
    }

    @Override
    public String delete(Long id) {
        workerRepository.deleteById(id);
        return "Worker with id:"+id+" is deleted";
    }
}
