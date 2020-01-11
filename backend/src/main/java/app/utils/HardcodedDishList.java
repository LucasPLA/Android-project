package app.utils;

import app.dataclasses.Dish;

// Singleton class of the hardcoded list of dishes. Can be replaced by a database
public class HardcodedDishList {

    private static HardcodedDishList instance = null;

    public Dish[] dishes;

    private HardcodedDishList() {
        this.dishes = new Dish[]{
                new Dish("Chili con carne", 4, 2),
                new Dish("mached carrots", 2, 1),
                new Dish("spinach tort",  3, 3),
                new Dish("onion soup", 3, 3),
                new Dish("mamaliga", 3, 1)
        };
    }

    public static HardcodedDishList getInstance() {
        if (instance == null)
            instance = new HardcodedDishList();

        return instance;
    }
}