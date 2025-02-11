package me.fil.aui_lab.film.function;

import me.fil.aui_lab.film.dto.PatchFilmRequest;
import me.fil.aui_lab.film.entity.Film;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateFilmWithRequestFunction implements BiFunction<Film, PatchFilmRequest, Film> {
    @Override
    public Film apply(Film entity, PatchFilmRequest request) {
        return Film.builder()
                .id(entity.getId())
                .name(request.getName() == null ? entity.getName() : request.getName())
                .productionYear(request.getProductionYear() == null ? entity.getProductionYear() : request.getProductionYear())
                .filmCategory(entity.getFilmCategory())
                .build();
    }
}
