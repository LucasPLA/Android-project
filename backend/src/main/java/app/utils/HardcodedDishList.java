package app.utils;

import app.dataclasses.Dish;

// Singleton class of the hardcoded list of dishes. Can be replaced by a database
public class HardcodedDishList {

    private static HardcodedDishList instance = null;

    public Dish[] dishes;

    private HardcodedDishList() {
        this.dishes = new Dish[]{
                new Dish("Chili con carne", new String[]{"meat", "rice", "beans"}),
                new Dish("mached carrots", new String[]{"carrots", "butter"}),
                new Dish("spinach tort", new String[]{"spinach", "eggs", "cream", "pie pastry"}),
                new Dish("onion soup", new String[]{"onions", "flour", "gruyere", "oil"}),
                new Dish("mamaliga", new String[]{"mamaliga"})
        };
    }

    public static HardcodedDishList getInstance() {
        if (instance == null)
            instance = new HardcodedDishList();

        return instance;
    }
}