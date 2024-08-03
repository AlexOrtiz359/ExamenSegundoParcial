package hn.lenguajes.creditos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes.creditos.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{
    
}
