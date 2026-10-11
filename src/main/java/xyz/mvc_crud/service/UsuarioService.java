package xyz.mvc_crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.mvc_crud.mapper.UsuarioMapper;
import xyz.mvc_crud.model.dto.UsuarioRequestDTO;
import xyz.mvc_crud.model.dto.UsuarioResponseDTO;
import xyz.mvc_crud.model.entity.Usuario;
import xyz.mvc_crud.repository.UsuarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private UsuarioMapper mapper;
    private UsuarioRepository repository;

    @Transactional
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto){
        if(repository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("Já existe uma conta associada a este e-mail.");
        }

        Usuario usuario = mapper.toEntity(dto);
        Usuario usuarioSalvo = repository.save(usuario);

        return mapper.toResponseDTO(usuarioSalvo);
    }

    public UsuarioResponseDTO buscarPorId(Long id){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return mapper.toResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> buscarTodos(){
        List<Usuario> usuarios = repository.findAll();

        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> mapper.toResponseDTO(usuario))
                .toList();

        return usuariosDTO;
    }

    @Transactional
    public void deletarUsuario(Long id){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuario.setAtivo(false);
        repository.save(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto){
        Usuario usuarioNoBanco = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if(!usuarioNoBanco.getEmail().equals(dto.email())){
            if(repository.existsByEmail(dto.email())){
                throw new IllegalArgumentException("Já existe uma conta associada a este e-mail.");
            }
        }

        usuarioNoBanco.setNome(dto.nome());
        usuarioNoBanco.setEmail(dto.email());
        usuarioNoBanco.setDataNascimento(dto.dataNascimento());

        Usuario usuarioAlterado = repository.save(usuarioNoBanco);

        return mapper.toResponseDTO(usuarioAlterado);
    }

}
