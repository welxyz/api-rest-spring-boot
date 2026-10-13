package xyz.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.apirest.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    Optional<Usuario> findByIdAndAtivoTrue(Long id);
    List<Usuario> findAllByAtivoTrue();
}
