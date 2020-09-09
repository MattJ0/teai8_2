package com.mattjohnson.teai8_2.service;

/**
 * @param <E> Entity type
 * @param <D> Dto type
 */
public interface IModelMapper<E, D> {

    D convertToDto(E e);

    E convertToEntity(D d);
}
