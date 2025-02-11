package me.fil.aui_lab.film.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchFilmRequest {
    private String name;
    private Integer productionYear;
}
