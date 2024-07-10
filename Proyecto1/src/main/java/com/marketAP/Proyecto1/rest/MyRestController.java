package com.marketAP.Proyecto1.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketAP.Proyecto1.models.User;
import com.marketAP.Proyecto1.models.userDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/apiv1")
public class MyRestController {

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


/*Este metodo es dependiente de la clase user creada y definida previamente 
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


    /*En este  metodo devolveremos una lista de usuarios utilizando la clase 
     * previamente definida en la carpeta models
    */

    @GetMapping("/usersList")
    public List<User> getUserList() {
        User user1= new User("Larry","Cañonga",31);
        User user2= new User("Benja","Lamelami",21);
        User user3= new User("Benito","Camesta",41);

        List<User> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
    

    /*Sintaxis para mandar un parametro en el request
     * aqui mismo se guardara la url:
     * 
     */
    

    @GetMapping("/userParams")
    public userDto getId(@RequestParam(required = false) Integer id) {

        userDto userDto1= new userDto("Roboto", "camaleon", 10);  
        System.out.println(id);
        userDto1.setId(id);
        
        return userDto1;//return id ;
    }
    

}
