package me.fil.aui_lab.film.function;

import me.fil.aui_lab.film.dto.GetFilmsResponse;
import me.fil.aui_lab.film.entity.Film;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class FilmsToResponseFunction implements Function<List<Film>, GetFilmsResponse> {
    @Override
    public GetFilmsResponse apply(List<Film> entities) {
        return GetFilmsResponse.builder()
                .films(entities.stream()
                        .map(film -> GetFilmsResponse.Film.builder()
                            .id(film.getId())
                            .name(film.getName())
                                .productionYear(film.getProductionYear())
                            .build())
                        .toList())
                .build();
    }
}
