package me.fil.aui_lab.film.dto;

import lombok.*;

import java.util.UUID;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetFilmsResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Film {
        private UUID id;
        private String name;
        private int productionYear;
    }

    @Singular
    private List<Film> films;
}
