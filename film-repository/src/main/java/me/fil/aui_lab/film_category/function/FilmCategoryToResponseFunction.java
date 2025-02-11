package me.fil.aui_lab.film_category.function;

import me.fil.aui_lab.film_category.dto.GetFilmCategoryResponse;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FilmCategoryToResponseFunction implements Function<FilmCategory, GetFilmCategoryResponse> {

    @Override
    public GetFilmCategoryResponse apply(FilmCategory entity) {
        return GetFilmCategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .popularity(entity.getPopularity())
                .build();
    }
}
