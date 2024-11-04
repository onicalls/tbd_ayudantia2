package tbd.ayudantia2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tbd.ayudantia2.persistence.entity.EstablecimientoEntity;
import tbd.ayudantia2.service.EstablecimientoService;

@RestController
public class EstablecimientoController {

    @Autowired
    private EstablecimientoService establecimientoService;

    @GetMapping("/establecimientos/{id}")
    public ResponseEntity<EstablecimientoEntity> getEstablecimiento(@PathVariable Integer id) {
        EstablecimientoEntity establecimientoEntity = establecimientoService.getEstablecimientoById(id);

        if (establecimientoEntity != null) {
            return ResponseEntity.ok(establecimientoEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}