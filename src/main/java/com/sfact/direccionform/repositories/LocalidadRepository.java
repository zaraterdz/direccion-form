package com.sfact.direccionform.repositories;

import com.sfact.direccionform.entities.Localidad;
import com.sfact.direccionform.entities.LocalidadId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, LocalidadId> {
    List<Localidad> findByEstado(String estado);
}
