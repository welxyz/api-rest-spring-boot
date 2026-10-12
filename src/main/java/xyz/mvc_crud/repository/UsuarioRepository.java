package xyz.mvc_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mvc_crud.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
