package com.codebusters.codebusters.configurations;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

  /*  // Método genérico para converter um DTO em uma entidade
    public static <D, E> E convertDTOToEntity(D dto, Class<E> entityClass) throws Exception {
        E entity = entityClass.getDeclaredConstructor().newInstance();

        // Realize a lógica de conversão aqui (por exemplo, usando reflexão)

        return entity;
    }

    // Método genérico para converter uma entidade em um DTO
    public static <D, E> D convertEntityToDTO(E entity, Class<D> dtoClass) throws Exception {
        D dto = dtoClass.getDeclaredConstructor().newInstance();

        // Realize a lógica de conversão aqui (por exemplo, usando reflexão)

        return dto;
    }

    // Método genérico para converter uma lista de DTOs em uma lista de entidades
    public static <D, E> List<E> convertDTOListToEntityList(List<D> dtoList, Class<E> entityClass) throws Exception {
        return dtoList.stream()
                .map(dto -> convertDTOToEntity(dto, entityClass))
                .collect(Collectors.toList());
    }

    // Método genérico para converter uma lista de entidades em uma lista de DTOs
    public static <D, E> List<D> convertEntityListToDTOList(List<E> entityList, Class<D> dtoClass) throws Exception {
        return entityList.stream()
                .map(entity -> convertEntityToDTO(entity, dtoClass))
                .collect(Collectors.toList());
    }*/
}
