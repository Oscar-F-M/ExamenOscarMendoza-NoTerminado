package com.example.ExamenOscarMendoza.repository;

import com.example.ExamenOscarMendoza.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenCompra, Integer> {
    boolean existsById(int id);
}
