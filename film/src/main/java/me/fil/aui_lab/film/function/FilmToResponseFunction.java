package me.fil.aui_lab.film.function;

import me.fil.aui_lab.film.dto.GetFilmResponse;
import me.fil.aui_lab.film.entity.Film;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FilmToResponseFunction implements Function<Film, GetFilmResponse> {

    @Override
    public GetFilmResponse apply(Film entity) {
        return GetFilmResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productionYear(entity.getProductionYear())
                .filmCategory(GetFilmResponse.FilmCategory.builder()
                        .id(entity.getFilmCategory().getId())
                        .build())
                .build();
    }
}
