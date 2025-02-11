package me.fil.aui_lab.film_category.controller.impl;

import lombok.extern.java.Log;
import me.fil.aui_lab.film_category.controller.api.FilmCategoryController;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class FilmCategoryDefaultController implements FilmCategoryController {
    private final FilmCategoryService service;

    public FilmCategoryDefaultController(FilmCategoryService service) {
        this.service = service;
    }

    @Override
    public void putFilmCategory(UUID id) {
        service.create(FilmCategory.builder().id(id).build());
    }

    @Override
    public void deleteFilmCategory(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        filmCategory -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
