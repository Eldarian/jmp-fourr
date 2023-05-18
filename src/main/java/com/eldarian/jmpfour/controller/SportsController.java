package com.eldarian.jmpfour.controller;

import com.eldarian.jmpfour.service.ETLService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Controller
@AllArgsConstructor
public class SportsController {

    @Autowired
    ETLService etlService;

    @GetMapping("/sports")
    public String displaySports(Model model) {
        //etlService.populateDatabase();
        etlService.populateModel(model);
        return "sports";
    }
}
