package com.jose.curso.springboot.webapp.springboot_web.controllers;

import com.jose.curso.springboot.webapp.springboot_web.controllers.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.abdera.protocol.client.RequestOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Indicamos que esta clase es un controlador REST de Spring Boot
// Los métodos devolverán datos en formato JSON
@RestController
// Prefijo común para todas las rutas de este controlador: /api/params
@RequestMapping("/api/params")
public class RequestParamsController {

  // Este método se ejecuta cuando se hace una petición GET a /api/params/foo
  @GetMapping("/foo")
  // El parámetro "message" se recibe desde la URL como query param (ej: ?message=Hola)
  // "required = false" significa que no es obligatorio enviarlo
  public ParamDto foo(@RequestParam(required = false) String message) {
    // Creamos un objeto ParamDto para devolver la respuesta
    ParamDto param = new ParamDto();
    // Si "message" viene en la URL, lo usamos; si no, ponemos un texto por defecto
    param.setMessage(
      message != null ? message : "No se ha recibido ningun mensaje"
    );
    // Asignamos un código fijo (0) a la respuesta
    param.setCode(0);
    // Devolvemos el objeto como JSON
    return param;
  }

  // Este método se ejecuta cuando se hace una petición GET a /api/params/bar
  @GetMapping("/bar")
  // Recibe dos parámetros desde la URL:
  // - "text": no obligatorio
  // - "code": no obligatorio, pero si no se envía se asigna el valor por defecto 0
  public ParamDto bar(
    @RequestParam(value = "text", required = false) String text,
    @RequestParam(
      value = "code",
      required = false,
      defaultValue = "0"
    ) Integer code
  ) {
    // Ejemplo de URL con parámetros: /api/params/bar?text=libros&code=2

    // Creamos un objeto ParamDto para devolver la respuesta
    ParamDto params = new ParamDto();
    // Si "text" viene en la URL, lo usamos; si no, ponemos un texto por defecto
    params.setMessage(
      text != null ? text : "No se ha recibido ninguna categoria"
    );
    // Asignamos el valor de "code" (si no viene, será 0 por defecto)
    params.setCode(code);

    // Devolvemos el objeto como JSON
    return params;
  }

  // Este método se ejecuta cuando se hace una petición GET a la ruta /request
  @GetMapping("/request")
  public ParamDto request(HttpServletRequest request) {
    // Creamos un objeto ParamDto que será la respuesta en formato JSON
    ParamDto params = new ParamDto();

    // Obtenemos el parámetro "code" directamente desde la petición HTTP
    // request.getParameter("code") devuelve un String, por eso usamos Integer.parseInt para convertirlo a número
    params.setCode(Integer.parseInt(request.getParameter("code")));

    // Obtenemos el parámetro "message" directamente desde la petición HTTP
    // Si en la URL se envía ?message=Hola, aquí se guardará "Hola"
    params.setMessage(request.getParameter("message"));

    // Devolvemos el objeto ParamDto como respuesta JSON
    return params;
  }
    // Este método se ejecuta cuando se hace una petición GET a la ruta /requestString
  @GetMapping("/requestString")
  public String requestString(HttpServletRequest requestString) {

    Integer code= Integer.parseInt(requestString.getParameter("code"));
    String message= requestString.getParameter("message");
    String mailString= requestString.getParameter("mail");

    // Devolvemos el objeto ParamDto como respuesta JSON
    return "El mensaje es: " + message + " y el código es: " + code + " y el mail es: " + mailString;
  }
}
