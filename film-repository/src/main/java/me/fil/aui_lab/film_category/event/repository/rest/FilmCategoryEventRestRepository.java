package me.fil.aui_lab.film_category.event.repository.rest;

import me.fil.aui_lab.film_category.event.repository.api.FilmCategoryEventRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class FilmCategoryEventRestRepository implements FilmCategoryEventRepository {
    private final RestTemplate restTemplate;

    public FilmCategoryEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void put(UUID id) {
        restTemplate.put("/api/categories/{id}", null, id);
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/categories/{id}", id);
    }
}
