package dev.vagnergrossklaus.springthymeleafcrud.service;

import dev.vagnergrossklaus.springthymeleafcrud.entity.Vehicle;
import dev.vagnergrossklaus.springthymeleafcrud.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository repository;

    public Iterable<Vehicle> findall(){
        return repository.findAll();
    }

    public Vehicle findById(Long id){
        return repository.findById(id).get();
    }

    public Vehicle save(Vehicle vehicle){
        return repository.save(vehicle);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
