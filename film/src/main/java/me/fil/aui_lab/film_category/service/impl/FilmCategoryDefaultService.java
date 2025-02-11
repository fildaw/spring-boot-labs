package me.fil.aui_lab.film_category.service.impl;

import me.fil.aui_lab.film_category.entity.FilmCategory;
import me.fil.aui_lab.film_category.repository.api.FilmCategoryRepository;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FilmCategoryDefaultService implements FilmCategoryService {
    private final FilmCategoryRepository filmCategoryRepository;

    public FilmCategoryDefaultService(FilmCategoryRepository filmCategoryRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
    }

    @Override
    public Optional<FilmCategory> find(UUID id) {
        return filmCategoryRepository.findById(id);
    }

    @Override
    public void create(FilmCategory filmCategory) {
        filmCategoryRepository.save(filmCategory);
    }

    @Override
    public void delete(UUID id) {
        filmCategoryRepository.findById(id).ifPresent(filmCategoryRepository::delete);
    }
}
