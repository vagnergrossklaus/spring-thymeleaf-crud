package dev.vagnergrossklaus.springthymeleafcrud.repository;

import dev.vagnergrossklaus.springthymeleafcrud.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
