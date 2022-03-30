package Ferreteria.back.proyecto.service.Impl;

import Ferreteria.back.proyecto.repository.ClienteRepository;
import Ferreteria.back.proyecto.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClienteImpl implements ServiceCliente {
    @Autowired
    ClienteRepository clienteRepository;

}
