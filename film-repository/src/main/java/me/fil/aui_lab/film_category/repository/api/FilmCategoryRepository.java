package me.fil.aui_lab.film_category.repository.api;

import me.fil.aui_lab.film_category.entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, UUID> {
    Optional<FilmCategory> findByName(String name);

    List<FilmCategory> findAllByPopularityGreaterThanEqual(int popularity);
}
