package me.fil.aui_lab.film.controller.api;

import me.fil.aui_lab.film.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface FilmController {
    @GetMapping("/api/films")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFilmsResponse getFilms();

    @GetMapping("/api/films/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFilmResponse getFilm(@PathVariable("id") UUID id);

    @GetMapping("/api/categories/{filmCategoryId}/films")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFilmsResponse getFilmCategoryFilms(@PathVariable("filmCategoryId") UUID filmCategoryId);

    @PutMapping("/api/films/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putFilm(@PathVariable("id") UUID id, @RequestBody PutFilmRequest request);

    @PatchMapping("/api/films/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void patchFilm(@PathVariable("id") UUID id, @RequestBody PatchFilmRequest request);

    @DeleteMapping("/api/films/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFilm(@PathVariable("id") UUID id);
}
