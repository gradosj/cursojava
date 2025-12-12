package com.jose.curso.springboot.webapp.springboot_web.controllers;

import com.jose.curso.springboot.webapp.springboot_web.controllers.models.User;
import com.jose.curso.springboot.webapp.springboot_web.controllers.models.dto.ParamDto;
import com.jose.curso.springboot.webapp.springboot_web.controllers.models.dto.ParamDtoMix;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private String[]listOfValues;
    @Value("${config.code}")
    private Integer code;


  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable(name = "message") String message) {
    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

  @GetMapping("/mix/{message}/{code}")
  public ParamDtoMix baz(
    @PathVariable(name = "message") String message,
    @PathVariable String code
  ) {
    ParamDtoMix param = new ParamDtoMix();
    param.setMessage(message);
    param.setCode(Integer.parseUnsignedInt(code));

    return param;
  }

  @PostMapping("/create")
  public User create(@RequestBody User user)  {
      //TODO: process POST request
      
      return user;
  }

  @GetMapping("/values")
  public Map<String,Object> values ()  {
      Map<String,Object> json  = new HashMap<>();
        json.put("username", this.username);
        json.put("message", this.message);
        json.put("listOfValues", this.listOfValues);
        json.put("code", this.code);

      return json;  
  }
  
  
}
