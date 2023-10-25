package com.codebusters.codebusters.interfaces;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<T, ID>{
    List<T> listAll();

    ResponseEntity<T> findById(ID id);

    ResponseEntity<Object> create(@Valid T dto);

    void update(ID id, @Valid T dto);

    void deleteById(ID id);
}
