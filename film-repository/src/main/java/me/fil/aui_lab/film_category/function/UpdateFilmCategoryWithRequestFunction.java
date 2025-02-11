package me.fil.aui_lab.film_category.function;

import me.fil.aui_lab.film_category.dto.PatchFilmCategoryRequest;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateFilmCategoryWithRequestFunction implements BiFunction<FilmCategory, PatchFilmCategoryRequest, FilmCategory> {
    @Override
    public FilmCategory apply(FilmCategory entity, PatchFilmCategoryRequest request) {
        return FilmCategory.builder()
                .id(entity.getId())
                .name(request.getName() == null ? entity.getName() : request.getName())
                .popularity(request.getPopularity() == null ? entity.getPopularity() : request.getPopularity())
                .build();
    }
}
