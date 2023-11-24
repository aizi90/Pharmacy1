package com.example.service;

import com.example.entities.Worker;

import java.util.List;

public interface WorkerService {
  List<Worker> getAllWorkerByPharmacyId();
  List<Worker>  getAllSalaryBySort();
  void save(Worker newWorker,Long pharmacyId) ;
  Worker findById(Long id);
  String delete(Long id) ;


}
