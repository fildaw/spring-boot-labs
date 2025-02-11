package me.fil.aui_lab.film_category.service.api;

import me.fil.aui_lab.film_category.entity.FilmCategory;

import java.util.Optional;
import java.util.UUID;

public interface FilmCategoryService {
    Optional<FilmCategory> find(UUID id);
    void create(FilmCategory filmCategory);
    void delete(UUID id);
}
