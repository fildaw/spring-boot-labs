package me.fil.aui_lab.film.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetFilmResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class FilmCategory {
        private UUID id;
        private String name;
        private int popularity;
    }

    private UUID id;
    private String name;
    private int productionYear;
    private FilmCategory filmCategory;
}
