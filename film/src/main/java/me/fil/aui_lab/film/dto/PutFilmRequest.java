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
public class PutFilmRequest {
    private String name;
    private int productionYear;
    private UUID filmCategory;
}
