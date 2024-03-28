package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.GenreModel;

public interface GenreService {
    GenreModel create(GenreModel genre);

    List<GenreModel> getAll();

    Optional<GenreModel> getById(Long id);

    GenreModel updateById(Long id, GenreModel genre);

    void delete(Long id);
}
