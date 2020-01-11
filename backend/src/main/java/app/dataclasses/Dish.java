package app.dataclasses;

import java.util.Objects;

public class Dish {

    private String name;
    private int appreciation;
    private int difficulty;

    public Dish(String name, int appreciation, int difficulty) {
        this.name = name;
        this.appreciation = appreciation;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(int appreciation) {
        this.appreciation = appreciation;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return appreciation == dish.appreciation &&
                difficulty == dish.difficulty &&
                name.equals(dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, appreciation, difficulty);
    }
}
