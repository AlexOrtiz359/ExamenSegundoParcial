package hn.lenguajes.creditos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes.creditos.modelos.Cliente;
import hn.lenguajes.creditos.servicios.ClienteServicio;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    
    
    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente nvoCliente) {
        
        return this.clienteServicio.crearCliente(nvoCliente);
    }

    @GetMapping("/obtener/todos")
    public List<Cliente> obtenerTodos(){
        return this.clienteServicio.obtenerTodos();
    }

}
