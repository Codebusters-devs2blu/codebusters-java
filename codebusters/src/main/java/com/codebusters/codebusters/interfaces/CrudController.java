package com.codebusters.codebusters.interfaces;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<T, ID>{
    List<T> listAll();

    ResponseEntity<T> findById(ID id);

    ResponseEntity<Object> create(@Valid  T dto);

    ResponseEntity<T> update(@Valid  T dto);

    ResponseEntity<T> deleteById(ID id);
}
