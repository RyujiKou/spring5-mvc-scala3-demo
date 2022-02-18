package dev.cooeeu.demo.spring5.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController:
  @GetMapping("/")
  def index(model: Model): String =
    model.addAttribute("title", "Spring MVC 5 Scalaデモ")
    "index"
