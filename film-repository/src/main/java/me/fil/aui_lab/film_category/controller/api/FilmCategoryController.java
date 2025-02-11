package me.fil.aui_lab.film_category.controller.api;

import me.fil.aui_lab.film_category.dto.GetFilmCategoriesResponse;
import me.fil.aui_lab.film_category.dto.GetFilmCategoryResponse;
import me.fil.aui_lab.film_category.dto.PatchFilmCategoryRequest;
import me.fil.aui_lab.film_category.dto.PutFilmCategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface FilmCategoryController {
    @GetMapping("/api/categories")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFilmCategoriesResponse getFilmsCategories();

    @GetMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFilmCategoryResponse getFilmCategory(@PathVariable("id") UUID id);

    @PutMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putFilmCategory(@PathVariable("id") UUID id, @RequestBody PutFilmCategoryRequest request);

    @PatchMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void patchFilmCategory(@PathVariable("id") UUID id, @RequestBody PatchFilmCategoryRequest request);

    @DeleteMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFilmCategory(@PathVariable("id") UUID id);
}
