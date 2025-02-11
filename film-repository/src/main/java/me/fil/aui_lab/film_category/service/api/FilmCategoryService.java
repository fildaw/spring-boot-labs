package me.fil.aui_lab.film_category.service.api;

import me.fil.aui_lab.film_category.entity.FilmCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FilmCategoryService {
    Optional<FilmCategory> find(UUID id);
    Optional<FilmCategory> findByName(String name);

    List<FilmCategory> findAllByPopularityGreaterThanEqual(int popularity);
    List<FilmCategory> findAll();

    void create(FilmCategory filmCategory);
    void update(FilmCategory filmCategory);
    void delete(UUID id);
}
