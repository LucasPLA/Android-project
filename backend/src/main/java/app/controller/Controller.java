package app.controller;

import app.dataclasses.Dish;
import app.utils.HardcodedDishList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/getDishes")
    public Dish[] getDishes() {
        return HardcodedDishList.getInstance().dishes;
    }
}
