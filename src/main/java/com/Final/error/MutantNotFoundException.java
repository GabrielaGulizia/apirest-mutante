package com.Final.error;

public class MutantNotFoundException extends RuntimeException {

    public MutantNotFoundException(Long id) {
        super("ERROR: El mutante " + id + " no se encuentra en nuestra base de datos");
    }

}
