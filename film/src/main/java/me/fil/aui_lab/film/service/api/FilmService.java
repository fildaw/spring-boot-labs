package me.fil.aui_lab.film.service.api;

import me.fil.aui_lab.film.entity.Film;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FilmService {
    Optional<Film> find(UUID id);

    List<Film> findAll();

    void create(Film film);
    void update(Film film);
    void delete(UUID id);

    Optional<List<Film>> findAllByFilmCategory(UUID filmCategoryId);
}
