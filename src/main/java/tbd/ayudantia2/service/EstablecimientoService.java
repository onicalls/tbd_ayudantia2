package tbd.ayudantia2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd.ayudantia2.persistence.entity.EstablecimientoEntity;
import tbd.ayudantia2.persistence.repository.EstablecimientoRepository;

@Service
public class EstablecimientoService {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    public EstablecimientoEntity getEstablecimientoById(Integer id) {
        return establecimientoRepository.getEstablecimientoId(id);
    }
}
