package me.fil.aui_lab.film_category.event.repository.api;

import java.util.UUID;

public interface FilmCategoryEventRepository {
    void put(UUID id);
    void delete(UUID id);
}
