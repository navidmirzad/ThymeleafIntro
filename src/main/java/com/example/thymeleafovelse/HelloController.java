package com.example.thymeleafovelse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller
@RequestMapping("/hello")
public class HelloController {

  LocalDate date = LocalDate.now();


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


}
