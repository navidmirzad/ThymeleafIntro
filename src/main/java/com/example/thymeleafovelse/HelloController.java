package com.example.thymeleafovelse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
// @RequestMapping("/hello")
public class HelloController {

    LocalDate date = LocalDate.now();


    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "register_success";
    }

    @GetMapping("")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("greeting", "hello! " + name);
        return "hello";
    }

    @GetMapping("/today")
    public String todayDate(Model model) {
        model.addAttribute("today", date);
        return "date";
    }

    @GetMapping("/weekday")
    public String weekDay(Model model) {
        model.addAttribute("weekday", date.getDayOfWeek());
        return "weekday";
    }

    @GetMapping("/fridayOrNot")
    public String fridayorNot(Model model) {
        model.addAttribute("fridayOrNot", date.getDayOfWeek());
        return "fridayOrNot";
    }

}
