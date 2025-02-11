package me.fil.aui_lab.film_category.controller.impl;

import me.fil.aui_lab.film_category.controller.api.FilmCategoryController;
import me.fil.aui_lab.film_category.dto.GetFilmCategoriesResponse;
import me.fil.aui_lab.film_category.dto.GetFilmCategoryResponse;
import me.fil.aui_lab.film_category.dto.PatchFilmCategoryRequest;
import me.fil.aui_lab.film_category.dto.PutFilmCategoryRequest;
import me.fil.aui_lab.film_category.function.FilmCategoriesToResponseFunction;
import me.fil.aui_lab.film_category.function.FilmCategoryToResponseFunction;
import me.fil.aui_lab.film_category.function.RequestToFilmCategoryFunction;
import me.fil.aui_lab.film_category.function.UpdateFilmCategoryWithRequestFunction;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class FilmCategoryDefaultController implements FilmCategoryController {
    private final FilmCategoryService service;
    private final FilmCategoryToResponseFunction filmCategoryToResponse;
    private final FilmCategoriesToResponseFunction filmCategoriesToResponse;
    private final RequestToFilmCategoryFunction requestToFilmCategory;
    private final UpdateFilmCategoryWithRequestFunction updateFilmCategoryWithRequest;

    public FilmCategoryDefaultController(FilmCategoryService service, FilmCategoryToResponseFunction filmCategoryToResponse, FilmCategoriesToResponseFunction filmCategoriesToResponse, RequestToFilmCategoryFunction requestToFilmCategory, UpdateFilmCategoryWithRequestFunction updateFilmCategoryWithRequest) {
        this.service = service;
        this.filmCategoryToResponse = filmCategoryToResponse;
        this.filmCategoriesToResponse = filmCategoriesToResponse;
        this.requestToFilmCategory = requestToFilmCategory;
        this.updateFilmCategoryWithRequest = updateFilmCategoryWithRequest;
    }

    @Override
    public GetFilmCategoriesResponse getFilmsCategories() {
        return filmCategoriesToResponse.apply(service.findAll());
    }

    @Override
    public GetFilmCategoryResponse getFilmCategory(UUID id) {
        return filmCategoryToResponse.apply(service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putFilmCategory(UUID id, PutFilmCategoryRequest request) {
        service.create(requestToFilmCategory.apply(id, request));
    }

    @Override
    public void patchFilmCategory(UUID id, PatchFilmCategoryRequest request) {
        service.update(updateFilmCategoryWithRequest.apply(
                service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                request)
        );
    }

    @Override
    public void deleteFilmCategory(UUID id) {
        service.find(id).ifPresentOrElse(
                film -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }
}
