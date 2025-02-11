package me.fil.aui_lab.film.entity;

import jakarta.persistence.*;
import lombok.*;
import me.fil.aui_lab.film_category.entity.FilmCategory;

import java.io.Serializable;
import java.util.UUID;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "films")
public class Film implements Comparable<Film>, Serializable {
    @Id
    private UUID id;

    private String name;
    private int productionYear;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "film_category")
    private FilmCategory filmCategory;

    @Override
    public int compareTo(Film o) {
        return productionYear - o.productionYear;
    }
}
