package me.fil.aui_lab.film_category.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchFilmCategoryRequest {
    private String name;
    private Integer popularity;
}
