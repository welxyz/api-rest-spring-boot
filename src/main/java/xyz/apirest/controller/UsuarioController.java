package xyz.apirest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.apirest.model.dto.UsuarioRequestDTO;
import xyz.apirest.model.dto.UsuarioResponseDTO;
import xyz.apirest.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> postUsuario(@RequestBody @Valid UsuarioRequestDTO dto){
        UsuarioResponseDTO usuarioResponseDTO = service.cadastrarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUsuario(@PathVariable Long id){
        UsuarioResponseDTO usuarioResponseDTO = service.buscarPorId(id);
        return ResponseEntity.ok(usuarioResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getUsuarios(){
        List<UsuarioResponseDTO> usuarios = service.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@RequestBody @Valid UsuarioRequestDTO dto, @PathVariable Long id){
        UsuarioResponseDTO usuarioResponseDTO = service.atualizarUsuario(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponseDTO);
    }

}
