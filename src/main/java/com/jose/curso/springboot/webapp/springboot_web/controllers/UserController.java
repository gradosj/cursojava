package com.jose.curso.springboot.webapp.springboot_web.controllers;

import com.jose.curso.springboot.webapp.springboot_web.controllers.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) {
    User user = new User("Esteban", "Lopez");
    user.setEmail(null);
    user.setName("Paco");
    model.addAttribute("title", "Hola Mundo Spring Boot");
    model.addAttribute("user", user);
    model.addAttribute("email", user.getEmail());
    return "details";
  }

  /* Aqui intento pasar el objeto a texto */
  @GetMapping("/list")
  public String list(ModelMap model) {
    model.addAttribute("title", "Listado de usuarios");
    return "list";
  }

  @ModelAttribute(
    "users"
  )/* Al hacer esto estamos cargando los usuarios en el modelo a nivel global (users) */
  public List<User> usersModels() {
    return Arrays.asList(
      new User("Pepa", "Gonzalez", "pruebas@gmail.com"),
      new User("Ana", "Lopez"),
      new User("Juan", "Perez"),
      new User("Marta", "Rodriguez")
    );
  }
}
