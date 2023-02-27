package model;

import java.time.Duration;
import java.util.Random;

public class Film {
    private static long id_counter = 1L;
    private long id;
    private String title;
    private String description;
    private Duration duration;

    public Film(String title, String description, long durationInMinutes) {
        this(title, description);
        duration = Duration.ofMinutes(durationInMinutes);
    }

    public Film(String title, String description) {
        this.id = id_counter;
        id_counter++;
        this.title = title;
        this.description = description;
    }

    public static Film generateGenericMarvelRandomMovie() {
        String[] heroes = {"spyder man", "doctor strange", "captain america", "kang"};
        String[] phrases = {"ultimate", "supreme", "in the multiverse"};
        Random random = new Random();
        String mainHero = heroes[random.nextInt(0, heroes.length)];
        String specialParticipation = heroes[random.nextInt(0, heroes.length)];
        String effectPhrase = phrases[random.nextInt(0, phrases.length)];
        String name = mainHero + " : " + effectPhrase;
        String description = (mainHero.equals(specialParticipation)) ? "the new old movie" : "co-staring " + specialParticipation + " again";
        return new Film(name, description);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}
