package me.fil.aui_lab.film.repository.api;

import me.fil.aui_lab.film.entity.Film;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
    Optional<Film> findByName(String name);

    List<Film> findAllByFilmCategory(FilmCategory filmCategory);

    List<Film> findAllByProductionYear(int year);
}
