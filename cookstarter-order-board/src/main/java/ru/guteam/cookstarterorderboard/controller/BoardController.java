package ru.guteam.cookstarterorderboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @GetMapping("/board/{restaurantId}")
    public String getBoard(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("restaurantId", restaurantId);
        return "board";
    }

}
