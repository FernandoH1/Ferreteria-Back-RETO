package Ferreteria.back.proyecto.controller;


import Ferreteria.back.proyecto.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ClienteController {

    @Autowired
    private ServiceCliente serviceCliente;


}
