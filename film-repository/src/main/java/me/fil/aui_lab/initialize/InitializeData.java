package me.fil.aui_lab.initialize;

import me.fil.aui_lab.film_category.entity.FilmCategory;
import me.fil.aui_lab.film_category.service.api.FilmCategoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final FilmCategoryService filmCategoryService;

    public InitializeData(FilmCategoryService filmCategoryService) {
        this.filmCategoryService = filmCategoryService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (filmCategoryService.findAll().isEmpty()) {
            FilmCategory scifi = FilmCategory.builder()
                    .id(UUID.fromString("58dadcf0-8a5c-46dd-8522-2ccf2714be80"))
                    .name("Sci-Fi").popularity(10).build();
            FilmCategory animation = FilmCategory.builder()
                    .id(UUID.fromString("0a0f18f2-24e9-46a7-9598-243386c6c854"))
                    .name("Animation").popularity(8).build();
            FilmCategory thriller = FilmCategory.builder()
                    .id(UUID.fromString("61539c74-1a3c-4020-8dcf-e1e49bbe251c"))
                    .name("Thriller").popularity(7).build();

            filmCategoryService.create(scifi);
            filmCategoryService.create(animation);
            filmCategoryService.create(thriller);
        }
    }
}
