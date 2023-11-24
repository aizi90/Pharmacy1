package com.example.controller;


import com.example.entities.Worker;
import com.example.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/workers/{pharmacyId}")
@RequiredArgsConstructor

public class WorkerConroller {
    private final WorkerService workerService;

    @GetMapping
    public List<Worker> findAllById(@PathVariable Long pharmacyId){
        return workerService.findAllById();
    }
    @PostMapping
    public String save(@RequestBody Worker newWorker,
                       @PathVariable Long pharmacyId){
        workerService.save(newWorker,pharmacyId);
        return "Worker: "+newWorker+" is saved";
    }



    @DeleteMapping("/{id}")
    public String deleteWorker(@PathVariable Long pharmacyId,
                               @PathVariable Long id){
        return workerService.delete(id);
    }
}

}
