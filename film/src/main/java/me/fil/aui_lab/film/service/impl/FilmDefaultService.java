package me.fil.aui_lab.film.service.impl;

import me.fil.aui_lab.film.entity.Film;
import me.fil.aui_lab.film.repository.api.FilmRepository;
import me.fil.aui_lab.film.service.api.FilmService;
import me.fil.aui_lab.film_category.repository.api.FilmCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmDefaultService implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmCategoryRepository filmCategoryRepository;

    public FilmDefaultService(FilmRepository filmRepository, FilmCategoryRepository filmCategoryRepository) {
        this.filmRepository = filmRepository;
        this.filmCategoryRepository = filmCategoryRepository;
    }

    @Override
    public Optional<Film> find(UUID id) {
        return filmRepository.findById(id);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public void create(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void update(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void delete(UUID id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Optional<List<Film>> findAllByFilmCategory(UUID filmCategoryId) {
        return filmCategoryRepository.findById(filmCategoryId)
                .map(filmRepository::findAllByFilmCategory);
    }
}
