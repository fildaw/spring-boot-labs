package me.fil.aui_lab.film_category.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.UUID;


public interface FilmCategoryController {
    @PutMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putFilmCategory(@PathVariable UUID id);

    @DeleteMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFilmCategory(@PathVariable UUID id);
}
