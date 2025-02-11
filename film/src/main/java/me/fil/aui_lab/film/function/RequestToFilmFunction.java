package me.fil.aui_lab.film.function;

import me.fil.aui_lab.film.dto.PutFilmRequest;
import me.fil.aui_lab.film.entity.Film;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToFilmFunction implements BiFunction<UUID, PutFilmRequest, Film> {
    @Override
    public Film apply(UUID uuid, PutFilmRequest request) {
        return Film.builder()
                .id(uuid)
                .name(request.getName())
                .productionYear(request.getProductionYear())
                .filmCategory(FilmCategory.builder()
                        .id(request.getFilmCategory())
                        .build())
                .build();
    }
}
