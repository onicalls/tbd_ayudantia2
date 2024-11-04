package tbd.ayudantia2.persistence.repository;

import tbd.ayudantia2.persistence.entity.EstablecimientoEntity;

public interface EstablecimientoRepository {
    EstablecimientoEntity getEstablecimientoId(Integer establecimientocodigo);
}
