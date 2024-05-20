package com.sfact.direccionform.repositories;

import com.sfact.direccionform.entities.Municipio;
import com.sfact.direccionform.entities.MunicipioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, MunicipioId> {
    List<Municipio> findByEstado(String estado);
}
