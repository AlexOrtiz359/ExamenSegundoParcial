package hn.lenguajes.creditos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.lenguajes.creditos.modelos.Prestamo;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long>{
    
}
