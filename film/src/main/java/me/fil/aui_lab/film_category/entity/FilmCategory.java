package me.fil.aui_lab.film_category.entity;

import jakarta.persistence.*;
import lombok.*;
import me.fil.aui_lab.film.entity.Film;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="film_categories")
public class FilmCategory implements Serializable {

    @Id
    private UUID id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "filmCategory", cascade = CascadeType.REMOVE)
    private List<Film> films;
}
