package me.fil.aui_lab.film_category.function;

import me.fil.aui_lab.film_category.dto.PutFilmCategoryRequest;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToFilmCategoryFunction implements BiFunction<UUID, PutFilmCategoryRequest, FilmCategory> {
    @Override
    public FilmCategory apply(UUID uuid, PutFilmCategoryRequest request) {
        return FilmCategory.builder()
                .id(uuid)
                .name(request.getName())
                .popularity(request.getPopularity())
                .build();
    }
}
