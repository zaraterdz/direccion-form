package com.sfact.direccionform.services;

import com.sfact.direccionform.entities.*;
import com.sfact.direccionform.repositories.EstadoRepository;
import com.sfact.direccionform.repositories.MunicipioRepository;
import com.sfact.direccionform.repositories.LocalidadRepository;
import com.sfact.direccionform.repositories.ColoniaRepository;
import com.sfact.direccionform.repositories.CodigoPostalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DireccionService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private LocalidadRepository localidadRepository;
    @Autowired
    private ColoniaRepository coloniaRepository;
    @Autowired
    private CodigoPostalRepository codigoPostalRepository;

    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    public List<Municipio> getMunicipiosByEstado(String estado) {
        return municipioRepository.findByEstado(estado);
    }

    public List<Localidad> getLocalidadesByEstado(String estadoId) {
        return localidadRepository.findByEstado(estadoId);
    }

    public List<Colonia> getColoniasByCodigoPostal(String cp) {
        return coloniaRepository.findByCp(cp);
    }

    public CodigoPostal getCodigoPostal(String cp) {
        return codigoPostalRepository.findById(cp).orElse(null);
    }

    public ResponseEntity<Map<String, String>> validarDireccion(Map<String, String> datos) {
        Map<String, String> response = new HashMap<>();

        String cp = datos.get("cp");
        String estado = datos.get("estado");
        String municipio = datos.get("municipio");
        String localidad = datos.get("localidad");
        String colonia = datos.get("colonia");

        //validacions
        //codigo postal
        if (!codigoPostalRepository.existsById(cp)) {
            response.put("error", "Código postal no válido");
            return ResponseEntity.badRequest().body(response);
        }

        //estado
        if (!estadoRepository.existsById(estado)) {
            response.put("error", "Estado no válido");
            return ResponseEntity.badRequest().body(response);
        }

        //municipio
        MunicipioId municipioId = new MunicipioId(municipio, estado);
        if (!municipioRepository.existsById(municipioId)) {
            response.put("error", "Municipio no válido");
            return ResponseEntity.badRequest().body(response);
        }

        //localidad
        LocalidadId localidadId = new LocalidadId(localidad, estado);
        if (!localidadRepository.existsById(localidadId)) {
            response.put("error", "Localidad no válida");
            return ResponseEntity.badRequest().body(response);
        }

        //colonia
        List<Colonia> colonias = coloniaRepository.findByCp(cp);
        boolean coloniaValida = colonias.stream().anyMatch(c -> c.getClave().equals(colonia));
        if (!coloniaValida) {
            response.put("error", "Colonia no válida");
            return ResponseEntity.badRequest().body(response);
        }

        response.put("mensaje", "Dirección válida");
        return ResponseEntity.ok(response);
    }
}
