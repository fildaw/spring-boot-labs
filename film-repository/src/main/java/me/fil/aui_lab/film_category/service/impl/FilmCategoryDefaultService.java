package me.fil.aui_lab.film_category.service.impl;

import me.fil.aui_lab.film_category.entity.FilmCategory;
import me.fil.aui_lab.film_category.event.repository.api.FilmCategoryEventRepository;
import me.fil.aui_lab.film_category.repository.api.FilmCategoryRepository;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmCategoryDefaultService implements FilmCategoryService {
    private final FilmCategoryRepository filmCategoryRepository;
    private final FilmCategoryEventRepository filmCategoryEventRepository;

    public FilmCategoryDefaultService(FilmCategoryRepository filmCategoryRepository, FilmCategoryEventRepository filmCategoryEventRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
        this.filmCategoryEventRepository = filmCategoryEventRepository;
    }

    @Override
    public Optional<FilmCategory> find(UUID id) {
        return filmCategoryRepository.findById(id);
    }

    @Override
    public Optional<FilmCategory> findByName(String name) {
        return filmCategoryRepository.findByName(name);
    }

    @Override
    public List<FilmCategory> findAllByPopularityGreaterThanEqual(int popularity) {
        return filmCategoryRepository.findAllByPopularityGreaterThanEqual(popularity);
    }

    @Override
    public List<FilmCategory> findAll() {
        return filmCategoryRepository.findAll();
    }

    @Override
    public void create(FilmCategory filmCategory) {
        filmCategoryEventRepository.put(filmCategory.getId());
        filmCategoryRepository.save(filmCategory);
    }

    @Override
    public void update(FilmCategory filmCategory) {
        filmCategoryRepository.save(filmCategory);
    }

    @Override
    public void delete(UUID id) {
        filmCategoryRepository.deleteById(id);
        filmCategoryEventRepository.delete(id);
    }
}
