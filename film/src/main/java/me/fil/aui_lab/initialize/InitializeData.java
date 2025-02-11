package me.fil.aui_lab.initialize;

import me.fil.aui_lab.film.entity.Film;
import me.fil.aui_lab.film.service.api.FilmService;
import me.fil.aui_lab.film_category.entity.FilmCategory;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final FilmService filmService;
    private final FilmCategoryService filmCategoryService;

    public InitializeData(FilmService filmService, FilmCategoryService filmCategoryService) {
        this.filmService = filmService;
        this.filmCategoryService = filmCategoryService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        FilmCategory scifi = FilmCategory.builder()
                .id(UUID.fromString("58dadcf0-8a5c-46dd-8522-2ccf2714be80"))
                .build();
        FilmCategory animation = FilmCategory.builder()
                .id(UUID.fromString("0a0f18f2-24e9-46a7-9598-243386c6c854"))
                .build();
        FilmCategory thriller = FilmCategory.builder()
                .id(UUID.fromString("61539c74-1a3c-4020-8dcf-e1e49bbe251c"))
                .build();

        filmCategoryService.create(scifi);
        filmCategoryService.create(animation);
        filmCategoryService.create(thriller);

        Film interstellar = Film.builder()
                .id(UUID.fromString("da129c31-4e55-424a-958d-29bdb864369a"))
                .name("Interstellar").productionYear(2014).filmCategory(scifi).build();
        Film dune = Film.builder()
                .id(UUID.fromString("452ff9fc-a8ff-46d4-a398-b198461f0358"))
                .name("Dune").productionYear(2021).filmCategory(scifi).build();
        Film dune2 = Film.builder()
                .id(UUID.fromString("eda48a67-6abd-443c-bcbb-a5ff643f6a33"))
                .name("Dune 2").productionYear(2024).filmCategory(scifi).build();

        Film shrek = Film.builder()
                .id(UUID.fromString("9aa559b0-e70e-47cf-a544-2a83492e00b4"))
                .name("Shrek").productionYear(2001).filmCategory(animation).build();
        Film odlot = Film.builder()
                .id(UUID.fromString("83931b6c-bb7e-471e-9319-b10291c9b162"))
                .name("Odlot").productionYear(2009).filmCategory(animation).build();
        Film madagaskar = Film.builder()
                .id(UUID.fromString("880a8db4-6cba-4f73-bd43-99adbe0d46b7"))
                .name("Madagaskar").productionYear(2005).filmCategory(animation).build();

        Film incepcja = Film.builder()
                .id(UUID.fromString("56d9aed4-5f03-486d-b51e-79b88cc5d4ba"))
                .name("Incepcja").productionYear(2010).filmCategory(thriller).build();
        Film labirynt = Film.builder()
                .id(UUID.fromString("3f339251-8a65-4690-8ec5-8b74c98591e1"))
                .name("Labirynt").productionYear(2013).filmCategory(thriller).build();
        Film tenet = Film.builder()
                .id(UUID.fromString("1072e689-d2e6-4c53-bc22-2b9cd9682744"))
                .name("Tenet").productionYear(2020).filmCategory(thriller).build();

        filmService.create(interstellar);
        filmService.create(dune);
        filmService.create(dune2);
        filmService.create(shrek);
        filmService.create(odlot);
        filmService.create(madagaskar);
        filmService.create(incepcja);
        filmService.create(labirynt);
        filmService.create(tenet);
    }
}
