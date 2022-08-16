package sn.faty.GestionStock.service.mappeur;

import java.util.List;

public interface EntityMapper<D,E> {

    E toEntity(D dto);

    D toDto(E entity);

  List<D> listDto(List<E> listEntity);

  List<E>  listEntity(List<D> listDto);

}
