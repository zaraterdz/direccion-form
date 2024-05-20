package com.sfact.direccionform.repositories;

import com.sfact.direccionform.entities.CodigoPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, String> {
}
