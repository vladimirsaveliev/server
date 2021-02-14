package cz.cvut.fit.tjv.semproject.server.services;

import org.springframework.data.domain.*;

import java.util.Optional;

public interface CrudService<T, K> {
    T create(T data);

    Optional<T> readById(K key);

    Page<T> readAll(Pageable pageable);

    void update(T data);

    void delete(K key);
}
