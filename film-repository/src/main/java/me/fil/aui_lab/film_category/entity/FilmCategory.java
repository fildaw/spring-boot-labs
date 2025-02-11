package me.fil.aui_lab.film_category.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String name;
    private int popularity;
}
