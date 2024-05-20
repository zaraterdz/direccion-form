package com.sfact.direccionform.controllers;

import com.sfact.direccionform.entities.Estado;
import com.sfact.direccionform.entities.Municipio;
import com.sfact.direccionform.entities.Localidad;
import com.sfact.direccionform.entities.Colonia;
import com.sfact.direccionform.entities.CodigoPostal;
import com.sfact.direccionform.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @GetMapping("/estados")
    public List<Estado> getAllEstados() {
        return direccionService.getAllEstados();
    }

    @GetMapping("/municipios/{estadoId}")
    public List<Municipio> getMunicipiosByEstado(@PathVariable String estadoId) {
        return direccionService.getMunicipiosByEstado(estadoId);
    }

    @GetMapping("/localidades/{estadoId}")
    public List<Localidad> getLocalidadesByEstado(@PathVariable String estadoId) {
        return direccionService.getLocalidadesByEstado(estadoId);
    }

    @GetMapping("/colonias/{cp}")
    public List<Colonia> getColoniasByCodigoPostal(@PathVariable String cp) {
        return direccionService.getColoniasByCodigoPostal(cp);
    }

    @GetMapping("/codigopostal/{cp}")
    public ResponseEntity<CodigoPostal> getCodigoPostal(@PathVariable String cp) {
        CodigoPostal codigoPostal = direccionService.getCodigoPostal(cp);
        if (codigoPostal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(codigoPostal, HttpStatus.OK);
    }

    @PostMapping("/validar")
    public ResponseEntity<Map<String, String>> validarDireccion(@RequestBody Map<String, String> datos) {
        return direccionService.validarDireccion(datos);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleCodigoPostalNotFound(Exception ex) {
    }
}