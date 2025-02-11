package me.fil.aui_lab.film_category.function;

import me.fil.aui_lab.film_category.dto.GetFilmCategoriesResponse;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.List;

@Component
public class FilmCategoriesToResponseFunction implements Function<List<FilmCategory>, GetFilmCategoriesResponse> {

    @Override
    public GetFilmCategoriesResponse apply(List<FilmCategory> entities) {
        return GetFilmCategoriesResponse.builder()
                .filmCategories(entities.stream()
                        .map(filmCategory -> GetFilmCategoriesResponse.FilmCategory.builder()
                                .id(filmCategory.getId())
                                .name(filmCategory.getName())
                                .popularity(filmCategory.getPopularity())
                                .build())
                        .toList())
                .build();
    }
}
