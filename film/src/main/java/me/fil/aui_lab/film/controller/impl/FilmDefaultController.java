package me.fil.aui_lab.film.controller.impl;

import me.fil.aui_lab.film.controller.api.FilmController;
import me.fil.aui_lab.film.dto.GetFilmResponse;
import me.fil.aui_lab.film.dto.GetFilmsResponse;
import me.fil.aui_lab.film.dto.PatchFilmRequest;
import me.fil.aui_lab.film.dto.PutFilmRequest;
import me.fil.aui_lab.film.function.FilmToResponseFunction;
import me.fil.aui_lab.film.function.FilmsToResponseFunction;
import me.fil.aui_lab.film.function.RequestToFilmFunction;
import me.fil.aui_lab.film.function.UpdateFilmWithRequestFunction;
import me.fil.aui_lab.film.service.api.FilmService;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class FilmDefaultController implements FilmController {
    private final FilmService service;
    private final FilmCategoryService categoryService;
    private final FilmToResponseFunction filmToResponse;
    private final FilmsToResponseFunction filmsToResponse;
    private final RequestToFilmFunction requestToFilm;
    private final UpdateFilmWithRequestFunction updateFilmWithRequest;

    public FilmDefaultController(FilmService filmService, FilmCategoryService categoryService, FilmToResponseFunction filmToResponse, FilmsToResponseFunction filmsToResponse, RequestToFilmFunction requestToFilm, UpdateFilmWithRequestFunction updateFilmWithRequest) {
        this.service = filmService;
        this.categoryService = categoryService;
        this.filmToResponse = filmToResponse;
        this.filmsToResponse = filmsToResponse;
        this.requestToFilm = requestToFilm;
        this.updateFilmWithRequest = updateFilmWithRequest;
    }

    @Override
    public GetFilmsResponse getFilms() {
        return filmsToResponse.apply(service.findAll());
    }

    @Override
    public GetFilmResponse getFilm(UUID id) {
        return service.find(id)
                .map(filmToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetFilmsResponse getFilmCategoryFilms(UUID filmCategoryId) {
        return service.findAllByFilmCategory(filmCategoryId)
                .map(filmsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putFilm(UUID id, PutFilmRequest request) {
        if (categoryService.find(request.getFilmCategory()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        service.create(requestToFilm.apply(id, request));
    }

    @Override
    public void patchFilm(UUID id, PatchFilmRequest request) {
        service.update(updateFilmWithRequest.apply(
                service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                request)
        );
    }

    @Override
    public void deleteFilm(UUID id) {
        service.find(id).ifPresentOrElse(
                film -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }
}
