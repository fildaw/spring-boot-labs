package me.fil.aui_lab.film_category.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetFilmCategoriesResponse {
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

    @Singular
    private List<FilmCategory> filmCategories;
}
