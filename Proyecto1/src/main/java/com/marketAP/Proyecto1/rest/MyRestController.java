package com.marketAP.Proyecto1.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.marketAP.Proyecto1.models.User;
import com.marketAP.Proyecto1.models.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/apiv1")
public class MyRestController {

    @Value("${config.userDb}")
    private String user;
    @Value("${config.passDb}")
    private String pass;
    @Value("${config.hostname}")
    private String host;
    /*
     * En esta api rest controller definiremos varias practicas las cuales
     * no iran ayudando a construir diferentes tipos y secciones de codigo
     * lo nombraremos como un repositorio base de backend
     */

    /*
     * Los endpoint son definidos por get mapping el cual en su interior
     * cuenta con el metodo a ejecutar y a su vez retornar la vista
     * en este primer en point raiz
     */
    @GetMapping("/")
    public String saludo() {
        return "Mae Govannen";
    }

    /*
     * Este metodo es dependiente de la clase user creada y definida previamente
     * en las carpetas models, y nos regresa el objeto por medio de la clase map
     * y hash map
     */
    @GetMapping("/user")
    public Map<String, Object> getMethodName() {
        Map<String, Object> response = new HashMap<>();
        User firstUser = new User("Diego", "Gutierrez", 32);
        response.put("ListUser", firstUser);

        return response;
    }

    /*
     * En este metodo devolveremos una lista de usuarios utilizando la clase
     * previamente definida en la carpeta models
     */

    @GetMapping("/usersList")
    public List<User> getUserList() {
        User user1 = new User("Larry", "Cañonga", 31);
        User user2 = new User("Benja", "Lamelami", 21);
        User user3 = new User("Benito", "Camesta", 41);

        List<User> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }

    /*
     * Sintaxis para mandar un parametro en el request
     * aqui mismo se guardara la url:
     * http://localhost:8080/apiv1/userParams?id=5
     * En este tipo de envio se tiene que nombrar la variable
     * dentro de la url si no regresara un null
     */

    @GetMapping("/userParams")
    // tuvimos que utilizar integer para no regresar errores con variables nulls
    public UserDto getId(@RequestParam(required = false) Integer id) {

        UserDto UserDto1 = new UserDto("Roboto", "camaleon", 10);
        UserDto1.setId(id);

        return UserDto1;// return id ;
    }

    @GetMapping({ "/userParamsUrl", "/userParamsUrl/", "/userParamsUrl/{id}" })
    public UserDto getIdParam(@PathVariable(required = false) Integer id) {
        /*
         * if (id == null) {
         * // Manejar el caso cuando id es null
         * id = null; // o cualquier valor predeterminado que prefieras
         * }
         */

        UserDto UserDto1 = new UserDto("Roboto2", "camaleon2", 10);
        UserDto1.setId(id);

        return UserDto1;
    }

    @GetMapping({ "/paramMix", "/paramMix/", "/paramMix/{nombre}", "/paramMix/{nombre}/", "/paramMix/{nombre}/{id}" })
    public Map<String, Object> getParamsMix(@PathVariable(required = false) String nombre,
            @PathVariable(required = false) Integer id) {
        UserDto UserDto1 = new UserDto(nombre, "camaleon2", 10);
        UserDto1.setId(id);
        // Map<String, Object> jsonResponse = new HashMap<>();
        Map<String, Object> jsonResponse = new LinkedHashMap<>();

        jsonResponse.put("nombreRecibido", nombre);
        jsonResponse.put("idRecibido", id);
        jsonResponse.put("objectUser", UserDto1);

        System.out.println(jsonResponse);
        return jsonResponse;

    }

    @PostMapping("/postExample")
    public UserDto postExample(@RequestBody UserDto userRequest) {
        UserDto usuarioprueba = userRequest;
        return usuarioprueba;
    }

    @GetMapping("/getDatosConexion")
    public Map<String, Object> getDatosConexion() {

        Map<String, Object> dataConexionJson = new LinkedHashMap();
        dataConexionJson.put("User", user);
        dataConexionJson.put("password", pass);
        dataConexionJson.put("hostname", host);

        return dataConexionJson;
    }

}
