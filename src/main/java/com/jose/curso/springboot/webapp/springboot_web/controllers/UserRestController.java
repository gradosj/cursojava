package com.jose.curso.springboot.webapp.springboot_web.controllers;

import com.jose.curso.springboot.webapp.springboot_web.controllers.models.User;
import com.jose.curso.springboot.webapp.springboot_web.controllers.models.dto.UserDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

  @GetMapping("/details")
  public UserDto details() {
    User user = new User("Jose", "Antonio");
    UserDto userDto = new UserDto();
    userDto.setUser(user);
    userDto.setTitle("Hola mundo");

    return userDto;
  }

  @GetMapping("/details-map")
  public Map<String, Object> detailsMap() {
    User user = new User("Esteban", "Lopez");
    Map<String, Object> body = new HashMap<>();

    body.put("title", "Hola Mundo Spring Boot");
    body.put("user", user);

    return body;
  }
}
