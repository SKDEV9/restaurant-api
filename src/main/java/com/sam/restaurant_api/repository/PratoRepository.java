package com.sam.restaurant_api.repository;

import com.sam.restaurant_api.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PratoRepository extends JpaRepository<Prato, Long> {
}
