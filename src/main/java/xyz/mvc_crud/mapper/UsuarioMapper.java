package xyz.mvc_crud.mapper;

import org.springframework.stereotype.Component;
import xyz.mvc_crud.model.dto.UsuarioRequestDTO;
import xyz.mvc_crud.model.dto.UsuarioResponseDTO;
import xyz.mvc_crud.model.entity.Usuario;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        if(dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setDataNascimento(dto.dataNascimento());

        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        if(usuario == null) return null;

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataNascimento(),
                usuario.getDataCadastro(),
                usuario.isAtivo()
        );
    }

}
